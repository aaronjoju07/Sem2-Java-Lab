public class Flight {
    private String flightNumber;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private double ticketPrice;

    // Constructor
    public Flight() {
        // Init Data members
        flightNumber = "Unknown";
        airline = "Unknown";
        departureCity = "Unknown";
        arrivalCity = "Unknown";
        ticketPrice = 0.0;
    }

    // Constructor Overloading
    public Flight(String flightNumber, String airline, String departureCity, String arrivalCity, Double ticketPrice) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.ticketPrice = ticketPrice;
    }

    // main method
    public static void main(String[] args) {
        // Objects
        Flight flight1 = new Flight("AA123", "American Airlines", "New York", "Los Angeles", 300.0);
        // Display Flight Details
        flight1.displayFlightDetails();
        System.out.println("Total Price for 4 Passengers: $" + flight1.calcTotalPrice(4));
        System.out.println("Total Price for 4 Passengers with 20% Discount: $" + flight1.calcTotalPrice(4, 20));
        System.out.println(
                "Total Price for 4 Passengers and 2 Children with 20% Children Discount: $"
                        + flight1.calcTotalPrice(4, 2, 20));

    }

    // Flight Details display method
    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Airline: " + airline);
        System.out.println("Departure City: " + departureCity);
        System.out.println("Arrival City: " + arrivalCity);
        System.out.println("Ticket Price: " + ticketPrice);
    }

    // Method overloading
    public double calcTotalPrice(int noOfPassengers) {
        return ticketPrice * noOfPassengers;
    }

    public double calcTotalPrice(int numPassengers, double discountPercentage) {
        double discountedPrice = ticketPrice * (1.0 - discountPercentage / 100.0);
        return discountedPrice * numPassengers;
    }

    public double calcTotalPrice(int numAdults, int numChildren, double childDiscountPercentage) {
        double totalPrice = (ticketPrice * numAdults)
                + (ticketPrice * (1.0 - childDiscountPercentage / 100.0) * numChildren);
        return totalPrice;
    }

}
