package appsTest;

public class SamsungTv {
    private boolean isOn;
    private int volume;

    public boolean isOn() {
        return isOn;
    }
    private int channel = 1;

    public void toggle() {
        isOn = !isOn;
    }

    public String increaseVolume() {
        volume++;
        if (!isOn) {
            return "Tv is not turned on";
        } else if (volume < 100) {
            return String.format("volume increases %d:", volume);
        }
        return String.format("Volume is: %d", volume);
    }

    public String decreaseVolume() {
        volume--;
        if(!isOn){
            return "Tv is not turned on";
        }
        else if(volume > 0) {
            return String.format("Volume decreased %d", volume);
        }
        return String.format("Volume is: %d", volume);
    }
    public int getVolume(){
        return volume;
    }

    public String channelsIncreases() {
        if(isOn && channel >= 1){
            channel++;
          return String.format("channel switched to %d", channel);
        }
        return String.format("channel is %d", channel);
    }

    public int getChannels() {
        return channel;
    }

    public String channelsDecreases() {
        if(isOn && channel <= 0){
            channel-=1;
            return String.format("channel switched to %d", channel);
        }
        return String.format("channel is %d", channel);
    }
}