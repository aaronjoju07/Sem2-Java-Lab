package Overloading;
public class MethodOverloading {
    public static void main(String[] args) {
        int addInt = add(4, 10);
        double addDouble = add(5.1, 2.4);
        System.out.println("MethodOverloading");
        System.out.println("int: " + addInt);
        System.out.println("double: " + addDouble);

    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b) {
        return a + b;
    }
}
