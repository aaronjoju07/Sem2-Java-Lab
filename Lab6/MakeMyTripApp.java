interface Bookable {
    void book();
}
@@ -18,20 +16,22 @@ public void book() {
    }
}

class Traveler {
    void bookTicket(Bookable bookable) {
class Traveler<T extends Bookable> {
    void bookTicket(T bookable) {
        System.out.println("Traveler is booking a ticket on MakeMyTrip");
        bookable.book();
    }
}

public class MakeMyTripApp {
    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        Bookable flight = new Flight();
        Bookable bus = new Bus();
        Traveler<Flight> flightTraveler = new Traveler<>();
        Traveler<Bus> busTraveler = new Traveler<>();

        Flight flight = new Flight();
        Bus bus = new Bus();

        traveler.bookTicket(flight);
        traveler.bookTicket(bus);
        flightTraveler.bookTicket(flight);
        busTraveler.bookTicket(bus);
    }
}