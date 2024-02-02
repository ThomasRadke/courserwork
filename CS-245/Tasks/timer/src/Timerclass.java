import java.util.Timer;
import java.util.TimerTask;

public class Timerclass {
    private int seconds;
    private int minutes;
    private int hours;
    private String currentcount;
    public Timerclass(int sex, int min, int hore){
        seconds = sex;
        minutes = min;
        hours = hore;
        Optimize();
        while(true){
            System.out.println(Countdown());
            if(currentcount.equals("00:00:00"))
                break;
        }

    }

    private void Optimize(){
        while(seconds >= 60){
            seconds-= 60;
            minutes++;
        }
        while(minutes >= 60){
            minutes -= 60;
            hours++;
        }
    }

    private String Countdown(){
        currentcount = hours + ":" + minutes + ":" + seconds;

        if(seconds == 0 & minutes == 0 & hours == 0){
            currentcount = "00:00:00";
            return currentcount;
        }

        if (seconds == 0) {
            seconds = 59;
            minutes--;
        }
        if (minutes == 0){
            if(hours == 0){
                minutes = 0;
            }
            else{
                minutes = 59;
                hours--;
            }

        }
        seconds--;
        return currentcount;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public void Add30secs(){
        seconds += 30;
        Optimize();
    }


}
