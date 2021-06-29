import java.time.LocalTime;

public class StreamTime {

    private LocalTime streamTime;

    public StreamTime(String time) {
        int hours = String.valueOf(/*figure this out*/);
        int minutes = String.valueOf(/*figure this out*/);
        int seconds = String.valueOf(/*figure this out*/);

        streamTime = LocalTime.of(hours, minutes, seconds);
    }
    
}
