package fireDrill2;

import java.util.Scanner;

public class TaskNine {
    public static void main(String[] args) {
        int sumOfNumbersCollected =0;
        Scanner input = new Scanner(System.in);
        for (int count = 1; count <= 10; count++) {
            int numberCollected=0;
                System.out.println("Enter a Score: ");
                numberCollected = input.nextInt();
            if(numberCollected >1 && numberCollected <100){
                sumOfNumbersCollected += numberCollected;
            }
        }
        System.out.printf("\nThe sum of all valid numbers collected is %s",sumOfNumbersCollected);
    }
}

