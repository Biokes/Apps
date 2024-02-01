package fireDrill1;

public class TaskEight {
    public static void main(String[] args) {
        int total =0;
        for(int count = 1; count <= 10 ; count++){
            int sumUp =0;
            if ((count % 4) == 0) {
                int numberToDisplay = 1;
                for(int innerCounter = 1; innerCounter <= 5; innerCounter ++) {
                    numberToDisplay *= count;
                    sumUp += numberToDisplay;

                }
                total+=sumUp;
            }
        }
        System.out.println(total);
    }
}

