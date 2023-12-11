package PractLab;

public class Car {
    public String maker;
    public String model;
    public int year;

    public  Car(String maker){
        this.maker=maker;
    }

    public Car(){
        this.year=2000;
    }

    public Car(int year){
        this.year =year;
    }

    void maker(String maker){
        System.out.println(maker);
    }
    void maker(){
        System.out.println("maker");
    }

    void start() {
        System.out.println("car started");
    }

    void stop() {
        System.out.println("car stopped");
    }

    public static void main(String[] args) {
        Car c1 = new Car(9000);
        c1.maker("maker");
        System.out.println(c1.maker);
        
        System.out.println(c1.year);
    }
}

