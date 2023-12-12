
import socialMedia.*;

class Main {
    public static void main(String[] args) {
        RegularUser regularUser = new RegularUser("001", "Aaron", "aaron@gmail.com");
        System.out.println("-------------------------------------------------------------");
        regularUser.displayProfile();
        System.out.println("-------------------------------------------------------------");
        regularUser.createPost("Heee!!");
        System.out.println("-------------------------------------------------------------");
        regularUser.displayProfile();
        System.out.println("-------------------------------------------------------------");
        regularUser.displayPost("001");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Admin User");
        AdminUser adminUser = new AdminUser("010", "Aj", "aj@gmail.com", "Full Access");
        adminUser.displayProfile();
        System.out.println("-------------------------------------------------------------");
        manipulateString("CiA2Java");
        System.out.println("-------------------------------------------------------------");
    }

    public static void manipulateString(String input) {
        // Count vowels
        int vowelCount = 0;
        String vowels = "aeiouAEIOU";
        for (char c : input.toCharArray()) {
            if (vowels.contains(String.valueOf(c))) {
                vowelCount++;
            }
        }
        System.out.println("Number of vowels: " + vowelCount);
        // Convert to uppercase
        String uppercaseString = input.toUpperCase();
        System.out.println("Uppercase string: " + uppercaseString);

        // Reverse using StringBuffer
        StringBuffer reversedString = new StringBuffer(input).reverse();
        System.out.println("Reversed string: " + reversedString.toString());
    }

}