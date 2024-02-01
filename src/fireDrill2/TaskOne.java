package fireDrill2;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        int sumOfNumbersCollected=0;
        Scanner input = new Scanner(System.in);
        for (int count = 0; count < 10; count++) {
            System.out.println("Enter a Score: ");
            int numberCollected = input.nextInt();
            sumOfNumbersCollected += numberCollected;
        }
        System.out.printf("\nThe sum of all numbers collected is %s",sumOfNumbersCollected);
    }
}
