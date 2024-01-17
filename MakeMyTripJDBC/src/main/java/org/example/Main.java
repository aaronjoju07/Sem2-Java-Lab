package org.example;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/IVM";
    static final String JDBC_USER = "postgres";
    static final String JDBC_PASSWORD = "0000";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MakeMyTrip - JDBC Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(8, 2));

            JLabel sourceLabel = new JLabel("Source:");
            JTextField sourceField = new JTextField();

            JLabel destinationLabel = new JLabel("Destination:");
            JTextField destinationField = new JTextField();

            JLabel dateLabel = new JLabel("Date:");
            JTextField dateField = new JTextField();

            JButton searchButton = new JButton("Search Flights");
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String source = sourceField.getText();
                    String destination = destinationField.getText();
                    String date = dateField.getText();

                    // Display available flights for the given day
                    displayAvailableFlights(source, destination, date);
                }
            });

            JButton insertButton = new JButton("Insert Flight");


            JLabel idLabel = new JLabel("FlightID:");
            JTextField idField = new JTextField();
            insertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Call the insert flight method
                    insertFlight(idField.getText(),sourceField.getText(), destinationField.getText(), dateField.getText());
                }
            });

            JButton deleteButton = new JButton("Delete Flight");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Call the delete flight method
                    deleteFlight(sourceField.getText(), destinationField.getText(), dateField.getText());
                }
            });

            JButton displayAllButton = new JButton("Display All Flights");
            displayAllButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display all flights
                    displayAllFlights();
                }
            });
            panel.add(idLabel);
            panel.add(idField);
            panel.add(sourceLabel);
            panel.add(sourceField);
            panel.add(destinationLabel);
            panel.add(destinationField);
            panel.add(dateLabel);
            panel.add(dateField);
            panel.add(new JLabel());
            panel.add(searchButton);
            panel.add(new JLabel());
            panel.add(insertButton);
            panel.add(new JLabel());
            panel.add(deleteButton);
            panel.add(new JLabel());
            panel.add(displayAllButton);
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static void displayAvailableFlights(String source, String destination, String date) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM flights WHERE source = ? AND destination = ? AND date = CAST(? AS DATE)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, source);
                preparedStatement.setString(2, destination);
                preparedStatement.setString(3, date);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Display available flights
                    displayFlightsDialog(resultSet, source, destination, date);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayFlightsDialog(ResultSet resultSet, String source, String destination, String date) {
        try {
            JDialog dialog = new JDialog();
            dialog.setTitle("Available Flights");
            dialog.setSize(400, 300);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 2));

            while (resultSet.next()) {
                String flightInfo = resultSet.getString("flight_number") + " - " +
                        resultSet.getString("source") + " to " +
                        resultSet.getString("destination") + " on " +
                        resultSet.getString("date");

                String flightNumber = resultSet.getString("flight_number"); // Store the flight number

                JButton bookButton = new JButton("Book");
                bookButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookFlight(flightNumber); // Use the stored flight number
                        JOptionPane.showMessageDialog(dialog, "Flight booked!\n" + flightInfo);
                        dialog.dispose();
                    }
                });

                panel.add(new JLabel(flightInfo));
                panel.add(bookButton);
            }

            dialog.add(panel);
            dialog.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void bookFlight(String flightNumber) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "UPDATE flights SET booked = true WHERE flight_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, flightNumber);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertFlight(String id,String source, String destination, String date) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Parse the date string into java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);

            // Exclude "flight_number" from the INSERT statement
            String sql = "INSERT INTO flights (flight_number,source, destination, date, booked) VALUES (?,?, ?, ?, false)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, source);
                preparedStatement.setString(3, destination);
                preparedStatement.setDate(4, sqlDate);
                preparedStatement.executeUpdate();

                // Retrieve the generated flight_number
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedFlightNumber = generatedKeys.getInt(1);
                        System.out.println("Generated Flight Number: " + generatedFlightNumber);
                    } else {
                        throw new SQLException("Failed to retrieve generated flight_number.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private static void deleteFlight(String source, String destination, String date) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "DELETE FROM flights WHERE source = ? AND destination = ? AND date = CAST(? AS DATE)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, source);
                preparedStatement.setString(2, destination);
                preparedStatement.setString(3, date);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayAllFlights() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM flights";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    displayFlightsDialog(resultSet, "All Flights", "All Destinations", "All Dates");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
