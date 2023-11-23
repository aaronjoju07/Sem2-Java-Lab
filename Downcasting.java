public class Downcasting {
    public static void main(String[] args) {

        Parent p = new Child();
        // downCasting
        Child c = (Child)p;
        c.display();
    }
}

/**
 * Parent
 */
class Parent {
    void display() {
        System.out.println("parent");
    }

}

/**
 * Child
 */
class Child extends Parent {
    void display() {
        System.out.println("Child");
    }

}
