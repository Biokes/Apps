package fireDrill1;

import fireDrill1.fireDrill2.InvalidNumberException;

import java.util.InputMismatchException;

import static diary.DiaryMain.print;

public class SevenSegmentsDisplay {
    public static String indexZero(String number) {
        if(number.charAt(0) == '1')
            return "******";
        return "      ";
    }
    public static String indexOne(String number){
        if(number.charAt(1) == '1' && number.charAt(5) == '1')
            return "*    *"+"\n*    *";
        if(number.charAt(1) == '1' && number.charAt(5) == '0')
            return "     *"+ "\n     *";
        if(number.charAt(1) == '0' && number.charAt(5) == '1')
            return "*     "+  "\n*     ";
        if(number.charAt(1) == '0' && number.charAt(5) == '0')
            return "      "+"\n      ";
        return "";

    }

    public static String indexTwo(String number) {
        if(number.charAt(2) == '1' && number.charAt(4) == '1')
            return "*    *\n*    *";
        if(number.charAt(2) == '1' && number.charAt(4) == '0')
            return "     *\n     *";
        if(number.charAt(2) == '0' && number.charAt(4) == '1')
            return "*     \n*     ";
        if(number.charAt(1) == '0' && number.charAt(5) == '0')
            return "      \n      ";
        return "";
    }
    public static String indexThree(String number) {
        if(number.charAt(3) == '1')
            return "******";
        return "      ";
    }
    public static String indexSix(String number) {
        if(number.charAt(6) == '1')
            return "******";
        return "      ";
    }

    public static boolean validate(String number) {
        if(!(number.matches("\\d+")))
            throw new InvalidNumberException();
        if(number.length() != 8)
            throw new InvalidNumberException();
        return false;
    }

    public static String segments(String numbers){
        try{
            validate(numbers);
            print(String.format("%s\n%s\n%s\n%s\n%s",
                    indexZero(numbers), indexOne(numbers),indexSix(numbers),indexTwo(numbers),indexThree(numbers)));
        }catch(InvalidNumberException invalidNumberException){
            print("Invalid number.");
        }
        catch(InputMismatchException exception){
            print("Wrong set of characters");
        }
        return null;
    }
    public static String display(String numbers){
            try {
                validate(numbers);
                if (numbers.charAt(7) == '1')
                    return  segments(numbers);
                else
                    return "OFF";
            } catch (InvalidNumberException invalidNumberException) {
                print("Invalid number.");
            } catch (InputMismatchException exception) {
                print("Wrong set of characters");
            }

        return "";
    }

}
