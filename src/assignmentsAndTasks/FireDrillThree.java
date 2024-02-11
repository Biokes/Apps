package assignmentsAndTasks;
import java.util.ArrayList;
public class FireDrillThree {
    public static int[] taskOne(int num1, int num2, int num3,int num4, int num5, int num6, int num8, int num7,int num9,int num10){
        int[]  numbers = new int[10];
        numbers [0] = num1;
        numbers [1] = num2;
        numbers [2] = num3;
        numbers [3] = num4;
        numbers [4] = num5;
        numbers [5] = num6;
        numbers [6] = num8;
        numbers [7] = num7;
        numbers [8] = num9;
        numbers [9] = num10;


        return numbers;
    }
    public static String taskTwo(int [] numbers){
        String returnValue = "";
        for (int number : numbers) {
            String output = number + "\n";
            System.out.println(output);
            returnValue += output;
        }
        return returnValue;
    }
    public static String  taskThree(int [] numbers){
        String output ="";
        for (int number : numbers) {
            System.out.print(number + " ");
            output += number + " ";
        }
        return output;
    }
    public static int[] taskFour(int [] numbers){
        ArrayList <Integer> returnValue1= new ArrayList<>();
        for(int index = 0; index < numbers.length; index++){
            if(index%2 ==0){
                System.out.print(numbers[index] + ", ");
                returnValue1.add(numbers[index]);
            }
        }
        int [] returnValue = new int[returnValue1.size()];
        for (int index = 0; index < returnValue.length; index++) {
            returnValue[index] =  returnValue1.get(index);
        }
        return returnValue;
    }
    public static int[] taskFive(int [] numbers){
        ArrayList<Integer> temporary = new ArrayList<>();
        for(int index = 0; index < numbers.length; index++){
            if(index %2 ==1){
                temporary.add(numbers[index]);
            }
        }
        int [] returningValues = new int[temporary.size()];
        for(int index = 0; index < temporary.size(); index++){
            returningValues[index] = temporary.get(index);
        }
        return returningValues;

    }
    public static int taskSix(int [] numbers){
        int sum=0;
        for(int index = 0; index < numbers.length; index++){
            if(index%2 ==0){
                sum+= numbers[index];
            }
        }
        return sum;
    }
    public static int taskSeven(int [] numbers){
        int sum=0;
        for(int index = 0; index < numbers.length; index++){
            if(index % 2 == 1){
                sum+= numbers[index];
            }
        }
        return sum;
    }
    public static int taskEight(int [] numbers){
        int least = numbers[0];
        for(int count =0; count < numbers.length;count++){
            if(numbers[count] < least && count % 2 ==1){
                least = numbers[count];
            }
        }
        return least;
    }
    public static int taskNine(int [] numbers){
        int least = numbers[1];
        for(int count =1; count < numbers.length;count++){
            if(numbers[count] < least && count % 2 == 0){
                least = numbers[count];
            }
        }
        return least;
    }
    public static int taskTen(int [] numbers){
        int maximum = numbers[0];
        for(int count =0; count < numbers.length;count++){
            if(numbers[count] > maximum && count % 2 ==0){
                maximum = numbers[count];
            }
        }
        return maximum;
    }
    public static int taskEleven(int [] numbers){
        int maximum = numbers[1];
        for(int count =0; count < numbers.length;count++){
            if(numbers[count] > maximum && count %2 == 1){
                maximum = numbers[count];
            }
        }
        return maximum;
    }
    public static int[] taskTwelve(int [] numbers) {
        for(int counter = 0; counter < numbers.length; counter+=2){
            int temporary;
            temporary = numbers[counter];
            numbers[counter] = numbers[counter+1] ;
            numbers[counter+1] = temporary;
        }
        return numbers;
    }
    public static int[] taskThirteen(int [] numbers){
        for(int counter = 0; counter < numbers.length; counter+=2){
            if ( numbers[counter]% 2==1 && numbers[counter+1]% 2== 1) {
                int temporary;
                temporary = numbers[counter] ;
                numbers[counter] = numbers[counter + 1];
                numbers[counter + 1] = temporary;
            }
        }
        return numbers;
    }
    public static int[] taskFourteen(int [] numbers){
        for(int counter = 0; counter < numbers.length; counter+=2){
            if ( numbers[counter]% 2== 0 && numbers[counter+1]% 2== 0) {
                int temporary = 0;
                numbers[counter] = temporary;
                numbers[counter] = numbers[counter + 1];
                numbers[counter + 1] = temporary;
            }
        }
        return numbers;
    }
    public static int[] taskFifteen(int [] numbers){
        for(int counter = 0; counter < numbers.length; counter+=2){
            if ( (numbers[counter]% 2 == 1 && numbers[counter+1]% 2== 0)|| (numbers[counter]% 2 == 0 && numbers[counter+1]% 2== 1)) {
                int temporary = numbers[counter] ;
                numbers[counter] = numbers[counter + 1];
                numbers[counter + 1] = temporary;
            }
        }
        return numbers;
    }
    public static int[] taskSixteen(int [] numbers){
        for(int counter = 0; counter < numbers.length; counter+=2){
            if ( (numbers[counter]% 2 == 1 && numbers[counter+1]% 2== 0)|| (numbers[counter]% 2 == 0 && numbers[counter+1]% 2== 1) ) {
                int temporary = numbers[counter];
                numbers[counter] = numbers[counter + 1];
                numbers[counter + 1] = temporary;
            }
        }
        return numbers;
    }
}