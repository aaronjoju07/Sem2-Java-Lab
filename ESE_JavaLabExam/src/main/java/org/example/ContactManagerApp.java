package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ContactManagerApp extends JFrame {
    private JTextField nameField, emailField, phoneField;
    public DefaultTableModel tableModel;
    public JTable contactTable;

    private Connection connection;

    public ContactManagerApp() {
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);

        JButton addButton = new JButton("Add Contact");
        JButton updateButton = new JButton("Update Contact");
        JButton deleteButton = new JButton("Delete Contact");
        JButton searchButton = new JButton("Search");
        JButton loadButton = new JButton("LoadData");

        tableModel = new DefaultTableModel();
        contactTable = new JTable(tableModel);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(loadButton);

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(contactTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Database connection
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/IVM";
            String user = "postgres";
            String password = "0000";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database");
        }

        // Event listeners

        loadContacts();
        System.out.println("Row count: " + tableModel.getRowCount());
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchContact();
//                loadContacts();
            }
        });


    }

    private void addContact() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and email are required fields");
            return;
        }

        try {
            String query = "INSERT INTO contacts (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Contact added successfully");
                loadContacts();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add contact");
            }

            // Close resources
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding contact to the database");
        }
    }


    private void updateContact() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and email are required fields");
            return;
        }

        try {
//            int selectedRow = contactTable.getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(this, "Please select a contact to update");
//                return;
//            }

//            int contactId = (int) contactTable.getValueAt(selectedRow, 0);

            String query = "UPDATE contacts SET  email=?, phone=? WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(3, name);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, phone);
//            preparedStatement.setInt(4, contactId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Contact updated successfully");
                loadContacts();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update contact");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating contact in the database");
        }
    }



    private void deleteContact() {
        String name = nameField.getText();
        try {
//            int selectedRow = contactTable.getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(this, "Please select a contact to delete");
//                return;
//            }


//            int contactId = (int) contactTable.getValueAt(selectedRow, 0);


            String query = "DELETE FROM contacts WHERE name=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, name);


                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Contact deleted successfully");
                    loadContacts();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete contact");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting contact from the database");
        }
    }


    private void searchContact() {
        String searchText = nameField.getText();

        try {
            tableModel.setRowCount(0);

            String query = "SELECT * FROM contacts WHERE name LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchText + "%"); // Use % for partial matching

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");

                    tableModel.addRow(new Object[]{name, email, phone});
                    System.out.println("Retrieved data: " + name + ", " + email + ", " + phone);
                    JOptionPane.showMessageDialog(this,"Retrieved data: " + name + ", " + email + ", " + phone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching contacts in the database: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            String query = "SELECT * FROM contacts";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder message = new StringBuilder("Contacts:\n");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                message.append("Name: ").append(name).append("\n");
                message.append("Email: ").append(email).append("\n");
                message.append("Phone: ").append(phone).append("\n");
                message.append("\n");

                tableModel.addRow(new Object[]{name, email, phone});
                System.out.println("Retrieved data: " + name + ", " + email + ", " + phone);
            }

            resultSet.close();
            statement.close();

            // Display data in a JOptionPane dialog
            JOptionPane.showMessageDialog(this, message.toString(), "Contact Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading contacts from the database: " + e.getMessage());
        }
    }

    private void loadContacts() {
        try {
            tableModel.setRowCount(0);

            String query = "SELECT * FROM contacts";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                tableModel.addRow(new Object[]{name, email, phone});
                System.out.println("Retrieved data: " + name + ", " + email + ", " + phone);
            }
System.out.println(resultSet);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading contacts from the database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ContactManagerApp app = new ContactManagerApp();
                app.setSize(600, 400);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
            }
        });
    }
}
