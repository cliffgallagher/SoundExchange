import java.util.ArrayList;
import java.io.File;
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
            File outputLogFiles = new File("./Output Log Files");
            if (!outputLogFiles.exists()) {
                outputLogFiles.mkdir();
            }
            File printedStreams = new File("./Output Log Files/" + getDate() + ".txt");
            printedStreams.createNewFile();
            PrintWriter writer = new PrintWriter(printedStreams);
            for (WAMUStream stream: streams) {
                writer.print(stream);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
