package PractLab;


public class Inheritance {
    public static void main(String[] args) {
        // Vehical v = new Vehical();
        Car c = new Car("T",2009);
        c.driver();
    }
}

class Vehical {
    public String brand;
    public int year;

    public Vehical(String brand,int year) {
        this.brand = brand;
        this.year = year;
    }

    public void start() {
        System.out.println("start");
    }

    public void stop() {
        System.out.println("stop");
    }

}

class Car extends Vehical{
    int numberOfDoors;

    public Car(String brand,int year) {
        super(brand, year);
        this.numberOfDoors = 4;
    }

    public void driver() {
        System.out.println("drive");
        System.out.println(brand + " "+numberOfDoors+" "+year);
    }

}