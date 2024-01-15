package org.example;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeMyTripJDBC {
    static final String JDBC_URL = "jdbc:postgresql://your-database-host:5432/your-database-name";
    static final String JDBC_USER = "your-username";
    static final String JDBC_PASSWORD = "your-password";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MakeMyTrip - JDBC Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 2));

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

            panel.add(sourceLabel);
            panel.add(sourceField);
            panel.add(destinationLabel);
            panel.add(destinationField);
            panel.add(dateLabel);
            panel.add(dateField);
            panel.add(new JLabel()); // Empty space
            panel.add(searchButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static void displayAvailableFlights(String source, String destination, String date) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM flights WHERE source = ? AND destination = ? AND date = ?";
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
            // Create a dialog to display available flights
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

                JButton bookButton = new JButton("Book");
                bookButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Mark the flight as booked in the database
                        bookFlight(resultSet.getString("flight_number"));
                        // Display a popup message
                        JOptionPane.showMessageDialog(dialog, "Flight booked!\n" + flightInfo);
                        // Close the dialog
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
}
