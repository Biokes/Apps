package fireDrill2;

import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        int sumOfNumbersEvenIndexesCollected=0;
        Scanner input = new Scanner(System.in);
        for (int count = 0; count < 10; count++) {
            System.out.println("Enter a Score: ");
            int numberCollected = input.nextInt();
            if(count %2== 0){
                sumOfNumbersEvenIndexesCollected += numberCollected;}
        }
        System.out.printf("\nThe sum of all numbers collected is %s",sumOfNumbersEvenIndexesCollected);
    }
}
