package Lab4;

public class Lab4 {
    
}
// Define the Bookable interface
public interface Bookable {
    boolean isAvailable();  // Check availability
    boolean book();         // Book the entity
    void cancelBooking();   // Cancel the booking
}

// Implement the Bookable interface in the Flight class
public class Flight implements Bookable {
    private String flightNumber;
    private boolean isBooked;

    // Constructor, getters, setters, etc.

    @Override
    public boolean isAvailable() {
        // Logic to check if the flight is available
        return !isBooked;
    }

    @Override
    public boolean book() {
        if (!isBooked) {
            isBooked = true;
            // Logic to perform booking
            System.out.println("Flight " + flightNumber + " booked successfully.");
            return true;
        } else {
            System.out.println("Flight " + flightNumber + " is already booked.");
            return false;
        }
    }

    @Override
    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            // Logic to cancel the booking
            System.out.println("Booking for flight " + flightNumber + " canceled.");
        } else {
            System.out.println("No booking found for flight " + flightNumber + ".");
        }
    }
}

// Similar implementation for other classes like User, Booking, etc.
