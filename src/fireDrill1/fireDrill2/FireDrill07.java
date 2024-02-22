package fireDrill1.fireDrill2;
import java.util.ArrayList;
public class FireDrill07 {
    private static final java.util.Scanner input = new java.util.Scanner(System.in);
    public static void adjascentAsterisks(){
        ArrayList<Integer> userInputs = new ArrayList<>();

        int number =1;
        while(number!= 22) {
            System.out.println("Enter a number betwwen 1 and 15 (inclusive) and enter 22 to stop: ");
            number = input.nextInt();
            while((number< 1 || number > 15) && number != 22){
                System.out.println("Enter a valid number and enter 22 to stop!!!!!: ");
                number = input.nextInt();
            }
            userInputs.add(number);
            if (number == 22) {
                break;
            }
        }
        for (int count : userInputs) {
            System.out.printf("%s : ",count);
            for (int num = 0; num < count; num++) {
                System.out.printf("%s","*");
            }
            System.out.println();

        }
    }
}
