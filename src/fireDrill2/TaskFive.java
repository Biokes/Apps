package fireDrill2;

import java.util.Scanner;

public class TaskFive {
        public static void main(String[] args) {
            int sumOfNumbersEvennNumbersCollected =0;
            Scanner input = new Scanner(System.in);
            for (int count = 1; count <= 10; count++) {
                System.out.println("Enter a Score: ");
                int numberCollected = input.nextInt();
                if(numberCollected %2== 0){
                    sumOfNumbersEvennNumbersCollected += numberCollected;
                }
            }
            System.out.printf("\nThe sum of all numbers collected is %s",sumOfNumbersEvennNumbersCollected);
        }
}
