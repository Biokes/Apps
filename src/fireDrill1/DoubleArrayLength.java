package fireDrill1;

public class DoubleArrayLength {

    public int getLengthDoubled(int[] numbers) {
        int length = numbers.length*2;
        return length;
    }



    public int[] getDoubled(int[] numbers) {
        int  length = getLengthDoubled(numbers);
        int [] doubledLength = new int [length];
        for(int counter=0;counter<  numbers.length;counter++){
            doubledLength[counter] = numbers[counter];
            doubledLength[counter+numbers.length] = doubledLength[counter]*2;
        }
        return doubledLength;
    }
}
