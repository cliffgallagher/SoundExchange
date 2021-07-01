import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class TimeSorter {

    private ArrayList<WAMUStream> streams;

    public TimeSorter() {
        streams = new ArrayList<>();
    }

    public static void createPrintedSortedDirectory() {
        File printedSortedDirectory = new File("./PrintedSortedStreamLogs");

        if(!printedSortedDirectory.exists()) {
            printedSortedDirectory.mkdir();
        }
    }

    public ArrayList<WAMUStream> getStreams() {
        return this.streams;
    }

    public void sortByTimeAndPrint(String fileName) {
        sortStreamLogByTime(fileName);
        printLog(fileName, this.streams);
    }
    
    private void printLog(String fileName, ArrayList<WAMUStream> list) {
        try {
            File logSortedByTime = new File("./PrintedSortedStreamLogs/" + fileName);
            FileWriter fileWriter = new FileWriter(logSortedByTime);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (WAMUStream stream: streams) {
                printWriter.println(stream);
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void sortStreamLogByTime(String fileName) {
        createArrayList(fileName);
        Collections.sort(getStreams());
    }

    private static void createArrayList(String fileName) {
        String pathForScanner = new String("./PrintedUnsortedStreamLogs/" + fileName);

        try (Scanner timeSortScanner = new Scanner(Paths.get(pathForScanner)).useDelimiter("\\t|\\n")) {

            while (timeSortScanner.hasNextLine()) {
                
                String ipAddress = timeSortScanner.next();
                String date = timeSortScanner.next();
                String time = timeSortScanner.next();
                String stream = timeSortScanner.next();
                String duration = timeSortScanner.next();
                String status = timeSortScanner.next();
                String referrer = timeSortScanner.next();
                
                WAMUStream streamObject = new WAMUStream(ipAddress, date, time, stream, duration, status, referrer);

                streams.add(streamObject);

            }

            timeSortScanner.close();
          
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
