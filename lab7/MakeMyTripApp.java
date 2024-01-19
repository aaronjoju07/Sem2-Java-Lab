public class MakeMyTripApp {
    public static void main(String[] args) {
        Traveler<Flight> flightTraveler = new Traveler<>();
        Traveler<Bus> busTraveler = new Traveler<>();

        Flight flight = new Flight();
        Bus bus = new Bus();

        flightTraveler.bookTicket(flight, () -> System.out.println("Booking action for Flight"));
        busTraveler.bookTicket(bus, () -> System.out.println("Booking action for Bus"));
    }
}
interface Bookable {
    void book();

    default void performBooking(BookingAction bookingAction) {
        bookingAction.book();
    }
}
interface BookingAction {
    void book();
}

class Flight implements Bookable {
    @Override
    public void book() {
        System.out.println("Booked a Flight on MakeMyTrip");
    }
}

class Bus implements Bookable {
    @Override
    public void book() {
        System.out.println("Booked a Bus on MakeMyTrip");
    }
}
class Traveler<T extends Bookable> {
    void bookTicket(T bookable, BookingAction bookingAction) {
        System.out.println("Traveler is booking a ticket on MakeMyTrip");
        bookable.performBooking(bookingAction);
    }
}

