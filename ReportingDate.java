import java.util.ArrayList;

public class ReportingDate {
    
    private ArrayList<WAMUStream> streams;
    private String date;

    public ReportingDate(String date) {
        streams = new ArrayList<>();
        this.date = date;
    }

    public ArrayList<WAMUStream> getStreams() {
        return this.streams;
    }

    public String getDate() {
        return this.date;
    }

    public void addStream(WAMUStream wamuStream) {
        if (this.date.equals(wamuStream.getDate())) {
            streams.add(wamuStream);
        }       
    }

    public int size() {
        return streams.size();
    }

    public String toString() {
        return streams.toString();
    }

}
