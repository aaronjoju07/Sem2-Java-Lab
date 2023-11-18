import java.time.LocalTime;

public class practice {
    public static void main(String[] args) {
        // Write a Java program to display the time in human readable format like,hours:minutes:seconds.
        LocalTime currTime =  LocalTime.now();
        System.out.println("Current Time: " + currTime);
        // Write a Java program to split a sentence in to array with the space delimiter.“Betty bought some butter”
        String s = "Betty bought some butter";
        String[] words = s.split(" ");
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }
        // Demonstrate Compile time Polymorphism and Run-time Polymorphism.
System.out.println("Compile time Polymorphism");
        // Here, the first addition
        // function is called
        System.out.println(add(2, 3));
 
        // Here, the second addition
        // function is called
        System.out.println(add(2.0, 3.0));

        System.out.println("Run-time Polymorphism.");
        
    
    }

     // First addition function
     public static int add(int a, int b)
     {
         return a + b;
     }
  
     // Second addition function
     public static double add(
         double a, double b)
     {
         return a + b;
     }
}
