package Lab4;

interface Bookable {
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

class Traveler {
    void bookTicket(Bookable bookable) {
        System.out.println("Traveler is booking a ticket on MakeMyTrip");
        bookable.book();
    }
}

public class MakeMyTripApp {
    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        Bookable flight = new Flight();
        Bookable bus = new Bus();

        traveler.bookTicket(flight);
        traveler.bookTicket(bus);
    }
}
