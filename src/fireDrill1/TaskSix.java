package fireDrill1;

public class TaskSix {
    public static void main(String[] args) {


        for(int count = 1; count <= 10 ; count++){
            if ((count % 4) == 0) {
                int numberToDisplay = 1;
                for(int innerCounter = 1; innerCounter <= 5; innerCounter ++) {
                    numberToDisplay *= count;

                    System.out.print(numberToDisplay +" " );
                }
            }
        }
    }

}
