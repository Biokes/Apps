package assignmentsAndTasks;

public class AirCondition {
    public boolean airConditionStatus;
    private int temperature;
    public void onAirCondition(){
        airConditionStatus = true ;
        temperature = 16;
    }
    public void offAirCondition(){
        airConditionStatus = false;
    }

    public boolean checkACStatus(){
        return airConditionStatus;
    }
    public String increaseTemperature(int number){
        String  returnValue="";
        if(checkACStatus()== true && (number+temperature)<=30){
            temperature += number;
            returnValue = String.format("temperature : %sdegrees", temperature);
        } else if (checkACStatus()== true && (number+temperature)>30) {
            returnValue = String.format("temperature : 30degrees", temperature);

        }
        else if(checkACStatus() == false ){
            returnValue = "ac is off";
        }
        return returnValue;
    }
    public String increaseTemperature(){
            String  returnValue="";
            if(checkACStatus() == true && (temperature++)<=30){
                temperature ++;
                returnValue = String.format("temperature : %sdegrees", temperature);
            } else if (checkACStatus() == true && (temperature++)>30) {
                temperature =30;
                returnValue = String.format("temperature : 30 %sdegrees", temperature);
            }
            else if (checkACStatus() == false){
                returnValue = "ac is off";
            }
        return returnValue;
    }
    public String decreaseTemperature(int number){
        String  returnValue="";
        if(checkACStatus()== true && (temperature - number) < 16){
            temperature = 16;
            returnValue = String.format("temperature : %sdegrees", temperature);
        } else if (checkACStatus()== true && (temperature-number)>16 ) {
            temperature -= number;
            returnValue = String.format("temperature : %sdegrees", temperature);

        }else if(checkACStatus() == false ){
            returnValue = "ac is off";
        }
        return returnValue;
    }
    public String decreaseTemperature(){
        String  returnValue="";
        if(checkACStatus() == true && (temperature-1)>16){
            temperature--;
            returnValue = String.format("temperature : %sdegrees", temperature);
        } else if (checkACStatus() == true && (temperature-1)<16) {
            temperature = 16;
            returnValue = String.format("temperature : 16 %sdegrees", temperature);
        }
        else if(checkACStatus() == false ){
            returnValue = "ac is off";
        }
        return returnValue;
    }


}
