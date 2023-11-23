public class Upcasting {

    public static void main(String[] args) {
        // Upcasting
        Sport sport1 = new Cricket();
        Sport sport2 = new Football();
        
        // Displaying functions
        sport1.display(); // Output: Cricket
        sport2.display(); // Output: Football
    }
}

class Cricket extends Sport {
    void display() {
        System.out.println("Cricket");
    }
}

class Football extends Sport {
    void display() {
        System.out.println("Football");
    }
}

/**
 * sport
 */
class Sport {
   void display(){
    System.out.println("Sport");
   } 
}
