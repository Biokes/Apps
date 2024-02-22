package fireDrill1.fireDrill2;

import java.util.Scanner;

public class TaskSeven {


        public static void main(String[] args) {
            int sumOfNumbersEvennNumbersCollected =0;
            int evenNumbers =0;
            Scanner input = new Scanner(System.in);
            for (int count = 1; count <= 10; count++) {
                System.out.println("Enter a Score: ");
                int numberCollected = input.nextInt();
                if(numberCollected %2== 0){
                    evenNumbers +=1;
                    sumOfNumbersEvennNumbersCollected += numberCollected;
                }
            }
            double average = sumOfNumbersEvennNumbersCollected/ evenNumbers;
            System.out.printf("\nThe average of all even numbers collected is %s\nsum of even numbers: ",average,sumOfNumbersEvennNumbersCollected);
        }
    }


