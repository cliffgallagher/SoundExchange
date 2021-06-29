import java.util.ArrayList;
import java.io.PrintWriter;

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

    public void printStreams() {
        try {
            PrintWriter writer = new PrintWriter("output.txt");
            for (WAMUStream stream: streams) {
                writer.print(stream);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
