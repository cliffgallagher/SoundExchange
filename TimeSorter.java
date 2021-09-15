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

    /*
        Creates the PrintedSortedDirectory, where the stream logs sorted by time will populate.
    */
    public static void createPrintedSortedDirectory() {
        File printedSortedDirectory = new File("./PrintedSortedStreamLogs");

        if(!printedSortedDirectory.exists()) {
            printedSortedDirectory.mkdir();
        }
    }

    private ArrayList<WAMUStream> getStreams() {
        return this.streams;
    }

    public void sortByTimeAndPrint(String fileName) {
        sortStreamLogByTime(fileName);
        printLog(fileName, this.streams);
    }
    
    /*
        Helper method for sortByTimeAndPrint(). Loops through the ArrayList of WAMUStream objects in each TimeSorter object, which have previously been sorted by sortStreamLogByTime(), and prints them.
    */
    private void printLog(String fileName, ArrayList<WAMUStream> list) {
        try {
            File logSortedByTime = new File("./PrintedSortedStreamLogs/" + fileName);
            FileWriter fileWriter = new FileWriter(logSortedByTime);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("IP address" + "\t" + "Date" + "\t" + "Time" + "\t" + "Stream" + "\t" + "Duration" + "\t" + "Status" + "\t" + "Referrer");
            for (WAMUStream stream: streams) {
                printWriter.println(stream);
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
        Helper method for sortByTimeAndPrint. Uses createArrayList() to create an ArrayList from whichever file in PrintedUnsortedStreamLogs you decide to pass as an argument, and sorts it using Collections.sort().
    */
    private void sortStreamLogByTime(String fileName) {
        createArrayList(fileName);
        Collections.sort(getStreams());
    }

    /*
        Helper method for sortStreamLogByTime(). Reads in the stream instances saved in whichever file in the PrintedUnsortedStreamLogs directory you decide to pass as an argument, turns each instance into a WAMUStream object, and adds it to an ArrayList.
    */
    private void createArrayList(String fileName) {
        String pathForScanner = new String("./PrintedUnsortedStreamLogs/" + fileName);

        try (Scanner timeSortScanner = new Scanner(Paths.get(pathForScanner)).useDelimiter("\\t|\\n")) {

            while (timeSortScanner.hasNext()) {
                
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
