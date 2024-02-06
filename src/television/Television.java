package television;

public class Television {
    private boolean isOn;
    private int stationNumber=1 ;
    private int volume;
    public boolean isOn() {

       return isOn;
   }

    public void toggle() {


        isOn= !isOn;
    }

    public String nextStation() {
        if(stationNumber >= 31){
            this.stationNumber =1;
        }
        if(!isOn){

            return "The tv is currently off😒😒";
        }
       this.stationNumber +=1;
       return String.format("station %s",stationNumber);
    }

    public String previousStation() {
      if (stationNumber==1) {
            this.stationNumber = 31;
        }
        stationNumber -=1;
      if(!isOn){
          return "The tv is currently off😒😒";
        }

        return String.format("station %s",stationNumber);
    }
    public String checkVolume(){
        if(!isOn){
            return "The tv is currently off😒😒";
        } else if (volume> 60) {
            return String.format("Max volume : %s",60);

        }
        return String.format("volume : %s",volume);
    }

    public String increaseVolume() {
        volume++;
        if(!isOn){
            return "The tv is currently off😒😒";
        }
        else if (volume > 61){
            return String.format("Max volume : %s",60);
        }
        return String.format("volume : %s",volume);
    }

    public String decreaseVolume() {
        volume--;
        if(!isOn){
            return "The tv is currently off😒😒";
        }
        else if (volume <=0){
            return String.format("Min volume : %s",0);
        }
        return String.format("volume : %s",volume);
    }
}
