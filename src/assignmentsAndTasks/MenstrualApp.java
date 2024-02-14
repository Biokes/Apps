package assignmentsAndTasks;

import java.time.LocalDateTime;
import java.util.InputMismatchException;

public class MenstrualApp {
    private String[] splitDate(String date) {
    String [] days = date.split("/");
     return days;
    }
    public boolean isDateValid(String date){
        if (!(validateDate(date).equals(true)))
            throw new IllegalArgumentException("Invalid date provided");
        return true;
    }
    private  Object validateDate(String day){
        String [] date = splitDate(day);
        try{
        if(Integer.parseInt(date[0]) < 1 || Integer.parseInt(date[0])>31)
            return false;
        else if(Integer.parseInt(date[1]) < 1 || Integer.parseInt(date[1])>12)
            return false;
        else if((Integer.parseInt(date[0]) < 1 || Integer.parseInt(date[0])>28)
                && Integer.parseInt(date[1]) == 2
                && Integer.parseInt(date[2])%4 != 0 )
            return false;
        else if((Integer.parseInt(date[0]) < 1 || Integer.parseInt(date[0])>29) && Integer.parseInt(date[1]) == 2 && Integer.parseInt(date[2])%4 == 0 )
            return false;
        else if((Integer.parseInt(date[0]) < 1 || Integer.parseInt(date[0]) >31) && (Integer.parseInt(date[1]) == 1 || Integer.parseInt(date[1]) == 3 ||
                Integer.parseInt(date[1]) == 5 || Integer.parseInt(date[1]) == 7|| Integer.parseInt(date[1]) == 8 || Integer.parseInt(date[1]) == 10
        || Integer.parseInt(date[1]) == 12))
            return false;
        else if((Integer.parseInt(date[0]) < 1 || Integer.parseInt(date[0]) >30) && (Integer.parseInt(date[2]) == 4 ||Integer.parseInt(date[2]) == 6 ||
            Integer.parseInt(date[2]) == 9|| Integer.parseInt(date[2]) == 11))
            return false;
        else if( (Integer.parseInt(date[2]) < 1980 ||  Integer.parseInt(date[2]) > Integer.valueOf(LocalDateTime.now().getYear())))
                return false;
        }
            catch (IllegalArgumentException exception){
                return ("invalid date supplied.");
            }
            catch(InputMismatchException exception){
                return ("invalid date supplied.");

            }
            catch(Exception exception){
             return ("invalid date supplied.");
            }
        return true;
    }
}
