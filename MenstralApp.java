import java.time.LocalDate;
import java.util.Scanner;

public class MensturalApps {
    private final Scanner input = new Scanner(System.in);
    private final LocalDate date = LocalDate.now();
    public MensturalApps(int lastFlowYear,int lastFlowMonth,int lastFlowDay){
        this.lastFlowYear = lastFlowYear;
        this.lastFlowMonth= lastFlowMonth;
        this.lastFlowDay=  lastFlowDay;
    }
    private final int[] month ={31,28,31,30,31,30,31,31,30,31,30,31};
    private int lastFlowYear;
    private int lastFlowMonth;
    private int lastFlowDay;
    private int nextFlowDay;
    private int nextFlowMonth;
    private int nextFlowYear;
    private int nextFlowStopYear;
    private int nextFlowStopMonth;
    private int nextFlowStopDay;
    private int yearOfBirth;
    private String userName;
    private String gender;
    public int flow;
    public void setLastFlowYear(int lastFlowYear){
        if(lastFlowYear > (date.getYear()))
            while(lastFlowYear > (date.getYear())){
               System.out.println("Pls Enter a valid year of your last monthly flow: ");
               lastFlowYear = input.nextInt();
            }
        this.lastFlowYear = lastFlowYear;
    }
    public int getLastFlowYear(){
        return lastFlowYear;
    }

    public void setLastFlowMonth( int lastFlowMonth) {

        while(lastFlowMonth <1 || lastFlowMonth> month.length){
            System.out.println("Pls Enter a valid month number  of your last flow: ");
            lastFlowMonth = input.nextInt();
        }
        this.lastFlowMonth = lastFlowMonth;
    }
    public int getLastFlowMonth(){
        return lastFlowMonth;
    }
    public void setLastFlowDay(int lastFlowDay){
        while(lastFlowDay < 1 || lastFlowDay > month[getLastFlowMonth()-1]){
            System.out.println("Enter the day your of the month that your last flow stopped: ");
            lastFlowDay = input.nextInt();
        }
        this.lastFlowDay = lastFlowDay;
    }
    public int getLastFlowDay(){

        return lastFlowDay;
    }
    public void setNextFlowYear(){
        if(lastFlowMonth == 12 && lastFlowDay >=4 ){
            this.nextFlowYear= getLastFlowYear()+1;
        }
        else{
            this.nextFlowYear = getLastFlowYear();
        }
    }
    public int getNextFlowYear(){
        return nextFlowYear;
    }
    public void setNextFlowMonth(){
        if(lastFlowDay+ 28 > month[lastFlowMonth-  1]){
            this.nextFlowMonth = lastFlowMonth+1;
            if(nextFlowMonth > month.length){
                this.nextFlowYear= lastFlowYear+1;
                this.nextFlowMonth=1;
            }
        }else {
            this.nextFlowMonth = lastFlowMonth;
        }
    }
    public int getNextFlowMonth(){
        return nextFlowMonth;
    }
    public void setNextFlowDay(){

        if(lastFlowDay+28 > month[lastFlowMonth-1]){
            this.nextFlowDay= (lastFlowDay+28)% month[lastFlowMonth-1];
            this.nextFlowMonth= nextFlowMonth+1;
        }
        else{
            this.nextFlowDay= lastFlowDay+28 ;
        }
    }
    public int getNextFlowDay(){
        return nextFlowDay;
    }
    public void setNextFlowStopYear(){
      if(getNextFlowDay()+getFlow() > month[getLastFlowMonth()-1] && getLastFlowMonth() == 12 ){
      this.nextFlowStopYear= getLastFlowYear()+1;
      }else if(getNextFlowDay()+getFlow() > month[getLastFlowMonth()-1] && getNextFlowMonth() <12 ){
          this.nextFlowStopYear = getNextFlowYear();
      }
    }
    public int getNextFlowStopYear(){
        return nextFlowStopYear;
    }
        public void setNextFlowStopMonth() {
            if (getNextFlowDay() + getFlow() > month[getLastFlowMonth()-1]) {
                nextFlowStopMonth = getLastFlowYear() + 1;
                if (nextFlowStopMonth == 13) {
                    this.nextFlowStopMonth = 1;
                    this.nextFlowStopYear = getLastFlowYear() + 1;
                }
            }
        }
        public int getNextFlowStopMonth(){
        return nextFlowStopMonth;
        }
        public void setNextFlowStopDay(){
            if(getNextFlowDay()+getFlow() > month[getNextFlowMonth()]){
                this.nextFlowStopDay =  (getNextFlowDay()+getFlow())%month[getNextFlowMonth()-1];
            }
              else{
                 this.nextFlowStopDay= getNextFlowDay()+getFlow();
            }
        }
        public int getNextFlowStopDay(){
        return nextFlowStopDay;
        }
        public void setUserAge(){
            int year;
            do{System.out.println("Enter your year of Birth: ");
            year= input.nextInt();
            }while(year < 0 ||year > calender.getYear());
            this.yearOfBirth = year;
        }
        private static final LocalDate calender = LocalDate.now();
        public int getUserAge(){
        return (calender.getYear())-yearOfBirth;
        }
        public void setUserName(String name){
            this.userName  = name ;
        }
        public void setFlowDuration( int flow ){

            while(flow <= 0){
                System.out.println("Enter your last period duration!!!: ");
                flow = input.nextInt();
            }
            this.flow = flow;
        }
        public int getFlow(){
            return flow;
        }
        public String getUserName(){
            return userName;
        }
        public void setGender(String gender){
            while(!(gender.equalsIgnoreCase("male")|| gender.equalsIgnoreCase("female"))){
                System.out.println("Enter a valid gender(male / female): ");
                gender = input.next();
            }
            this.gender = gender;
        }
        public String getGender(){
            return gender;
        }
        public void setUserDetails(MensturalApps object){
            object.setGender("unknown");
            if(object.getGender().equalsIgnoreCase("female")){
            System.out.println("Your name pls:");
            String name = input.next();
            object.setUserName(name);
            object.setUserAge();
           if(object.getUserAge() < 10){
               System.out.println("Sorry,This apps can only help to predict menstruation dates and ovulation dates.");
           }else {
               System.out.println("Enter the last year you had your last period: ");
               int year = input.nextInt();
               object.setLastFlowYear(year);
               System.out.println("Enter the last month number you had your last period: ");
               int monthOfLastFlow1 = input.nextInt();
               object.setLastFlowMonth(monthOfLastFlow1);
               System.out.println("Enter the last day of your last Period: ");
               int dayOfLastFlow1 = input.nextInt();
               System.out.println("How many days did your last period: ");
               int flowDuration = input.nextInt();
               setFlowDuration(flowDuration);
               object.setLastFlowDay(dayOfLastFlow1);
               object.setNextFlowYear();
               object.setNextFlowMonth();
               object.setNextFlowDay();
               object.setNextFlowStopYear();
               object.setNextFlowStopMonth();
               object.setNextFlowStopDay();
               name = object.getUserName();
               int periodDuration = object.getFlow();
               int flowYear = object.getNextFlowYear();
               int flowMonth = object.getNextFlowMonth();
               int flowDay = object.getNextFlowDay();
               int stopYear = object.getNextFlowStopYear();
               int stopMonth = object.getNextFlowStopMonth();
               int stopDay = object.getNextFlowStopDay();
               System.out.printf("""

                               Dear %s,
                               Your next menstruation is predicted to start on %s/%s/%s 
                               Its expected to end on %s/%s/%s with the period lasting %s days.""",
                       name, flowYear, flowMonth, flowDay, stopYear, stopMonth, stopDay,periodDuration);
           }
           }else{
                System.out.println("This app is Strictly for The female Gender.\nThank You.");
            }
        }
}
