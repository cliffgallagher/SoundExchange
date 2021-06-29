import java.time.LocalTime;

public class TimeForSort {

    private int hours;
    private int minutes;
    private int seconds;
    private LocalTime timeForSort;

    public TimeForSort(String time) {
        this.hours = Integer.valueOf(time.split(":")[0]);
        this.minutes = Integer.valueOf(time.split(":")[1]);
        this.seconds = Integer.valueOf(time.split(":")[2]);

        timeForSort = LocalTime.of(hours, minutes, seconds);
    }

    public LocalTime getTimeForSort() {
        return timeForSort;
    }

    public String toString() {
        return timeForSort.toString();
    }
    
}
