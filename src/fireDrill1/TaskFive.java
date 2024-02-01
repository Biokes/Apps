package fireDrill1;

public class TaskFive {
    public static void main(String[] args) {
        for(int count = 1; count <= 10 ; count++){
            if ((count % 4) == 0) {
                for(int innerCounter = 0; innerCounter <= 4; innerCounter ++) {
                    System.out.print(count +"");
                }
                System.out.print(" ");
            }
        }
    }
}
