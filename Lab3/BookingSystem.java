public class BookingSystem {

    public static void main(String[] args) {
        System.out.println("\nBooking Details");

        FlightBooking flightBooking = new FlightBooking("FL-123", 500.0, "Economy");
        double flightCost = flightBooking.calculateCost(2);
        System.out.println("\nTotal cost for Flight Booking: " + flightCost);

        HotelBooking hotelBooking = new HotelBooking("HB-456", 120.0, 5);
        double hotelCost = hotelBooking.calculateCost(3);
        System.out.println("Total cost for Hotel Booking: " + hotelCost);

        hotelBooking.displayTotalCost(3);
    }
}

abstract class Booking {
    protected String bookingId;
    protected double costPerNight;

    public Booking(String bookingId, double costPerNight) {
        this.bookingId = bookingId;
        this.costPerNight = costPerNight;
    }

    public abstract double calculateCost(int numberOfNights);
}

class FlightBooking extends Booking {
    private String seatClass;

    public FlightBooking(String bookingId, double costPerNight, String seatClass) {
        super(bookingId, costPerNight);
        this.seatClass = seatClass;
    }

    @Override
    public double calculateCost(int numberOfNights) {
        // For simplicity, assuming costPerNight represents the ticket price
        return costPerNight * numberOfNights;
    }
}

final class HotelBooking extends Booking {
    private int numberOfRooms;

    public HotelBooking(String bookingId, double costPerNight, int numberOfRooms) {
        super(bookingId, costPerNight);
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public double calculateCost(int numberOfNights) {
        return costPerNight * numberOfRooms * numberOfNights;
    }

    public final void displayTotalCost(int numberOfNights) {
        double totalCost = calculateCost(numberOfNights);
        System.out.println("Total Cost for " + bookingId + ": " + totalCost + "\n");
    }
}
