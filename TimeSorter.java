import java.util.ArrayList;
import java.io.File;

public class TimeSorter {

    ArrayList<WAMUStream> streams;

    public TimeSorter() {
        streams = new ArrayList<>();
    }

    public static void createPrintedSortedDirectory() {
        File printedSortedDirectory = new File("./PrintedSortedStreamLogs");

        if(!printedSortedDirectory.exists()) {
            printedSortedDirectory.mkdir();
        }
    }
    
}
