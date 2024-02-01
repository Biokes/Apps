package fireDrill2;

import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        double sumOfNumbersCollected=0;
        Scanner input = new Scanner(System.in);
        for (int count = 0; count < 10; count++) {
            System.out.println("Enter a Score: ");
            int numberCollected = input.nextInt();
            sumOfNumbersCollected += numberCollected;
        }
        double average = sumOfNumbersCollected/10;
        System.out.printf("\nThe sum of all numbers collected is %.2f\naverage is %.1f",sumOfNumbersCollected,average);
    }
}
