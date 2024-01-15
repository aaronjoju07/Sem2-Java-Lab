import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MakeMyTripApp {
    private static List<Flight> flightList;

    public static void main(String[] args) {
        // Initialize sample flight list
        initializeSampleFlights();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MakeMyTrip");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 2));

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

                    Flight foundFlight = searchFlight(source, destination, date);

                    if (foundFlight != null) {
                        // Display flight details in a popup message
                        JOptionPane.showMessageDialog(frame, "Flight found!\n" + foundFlight.toString());
                    } else {
                        JOptionPane.showMessageDialog(frame, "No matching flights found.");
                    }
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

    private static void initializeSampleFlights() {
        flightList = new ArrayList<>();
        flightList.add(new Flight("New York", "Los Angeles", "2024-01-15"));
        flightList.add(new Flight("Chicago", "Miami", "2024-01-16"));
        flightList.add(new Flight("San Francisco", "Seattle", "2024-01-17"));
        flightList.add(new Flight("Boston", "Atlanta", "2024-01-18"));
        flightList.add(new Flight("Denver", "Dallas", "2024-01-19"));
        flightList.add(new Flight("Las Vegas", "Phoenix", "2024-01-20"));
        flightList.add(new Flight("Houston", "Orlando", "2024-01-21"));
        flightList.add(new Flight("Detroit", "Minneapolis", "2024-01-22"));
        flightList.add(new Flight("Portland", "Vancouver", "2024-01-23"));
        flightList.add(new Flight("Toronto", "Montreal", "2024-01-24"));
        flightList.add(new Flight("London", "Paris", "2024-01-25"));
        flightList.add(new Flight("Berlin", "Rome", "2024-01-26"));
    }

    private static Flight searchFlight(String source, String destination, String date) {
        for (Flight flight : flightList) {
            if (flight.getSource().equalsIgnoreCase(source) &&
                    flight.getDestination().equalsIgnoreCase(destination) &&
                    flight.getDate().equals(date)) {
                return flight;
            }
        }
        return null;
    }

    private static class Flight {
        private String source;
        private String destination;
        private String date;

        public Flight(String source, String destination, String date) {
            this.source = source;
            this.destination = destination;
            this.date = date;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }

        public String getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "Flight: " + source + " to " + destination + " on " + date;
        }
    }
}
