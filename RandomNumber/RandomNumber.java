import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    int randomValue;
    int attemptCount;

    public RandomNumber(int randomValue) {
        this.randomValue = randomValue;
        this.attemptCount = 5;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int randVal = random.nextInt(100) + 1;
        RandomNumber number = new RandomNumber(randVal);
        number.randCheck();

    }

    public void randCheck() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(randomValue);
            for (int i = 0; i < attemptCount; i++) {
                int RemainingCount = attemptCount - i;
                System.out.println("Remaining " + RemainingCount + " attempts");
                System.out.println("Guss the number ");
                int gussNumber = scanner.nextInt();
                if (gussNumber == randomValue) {
                    System.out.println("Woww....Gussed Right!..");
                    break;
                } else {
                    System.out.println("Wrong Guss!!!");
                    if (gussNumber < randomValue) {
                        System.out.println("Hint:gussed is less than RandomNumber");
                    } else {
                        System.out.println("Hint:gussed is greater than RandomNumber");
                    }
                }
            }
        }
    }
}
