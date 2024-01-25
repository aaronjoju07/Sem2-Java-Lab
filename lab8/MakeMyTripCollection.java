import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        MakeMyTripCollection makeMyTripCollection = new MakeMyTripCollection();


        makeMyTripCollection.addFlight(new Flight("AI101", "DEL", "BOM", 500.0));
        makeMyTripCollection.addFlight(new Flight("UA202", "NYC", "LAX", 700.0));
        makeMyTripCollection.addFlight(new Flight("EK303", "DXB", "JFK", 1000.0));


        List<Flight> delhiFlights = makeMyTripCollection.getFlightsBySource("DEL");
        System.out.println("Flights from DEL: " + delhiFlights);


        List<Flight> jfkFlights = makeMyTripCollection.getFlightsByDestination("JFK");
        System.out.println("Flights to JFK: " + jfkFlights);
    }
}
// Entity classes
class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private double price;

    public Flight(String flightNumber, String source, String destination, double price) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }



    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}


class MakeMyTripCollection {
    private Map<String, List<Flight>> flightsBySource;
    private Map<String, List<Flight>> flightsByDestination;

    public MakeMyTripCollection() {
        this.flightsBySource = new HashMap<>();
        this.flightsByDestination = new HashMap<>();
    }


    public void addFlight(Flight flight) {
        flightsBySource.computeIfAbsent(flight.getSource(), k -> new ArrayList<>()).add(flight);
        flightsByDestination.computeIfAbsent(flight.getDestination(), k -> new ArrayList<>()).add(flight);
    }


    public List<Flight> getFlightsBySource(String source) {
        return flightsBySource.getOrDefault(source, new ArrayList<>());
    }


    public List<Flight> getFlightsByDestination(String destination) {
        return flightsByDestination.getOrDefault(destination, new ArrayList<>());
    }
}


