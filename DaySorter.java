import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;
import java.nio.file.Paths;

public class DaySorter {

    public DaySorter() {}

    private static final LocalTime NOON = LocalTime.NOON;

    /*
    A helper method for parseStreamGuysReportByDay().
    
    Generates two text files, YYYY-MM-DD_AM.txt and YYYY-MM-DD_PM.txt, for each day that someone streamed WAMU. If files for a particular day have not been created yet, it will create the file. If the files have been created already, nothing happens.

    */
    private static void createOutputFiles(WAMUStream stream) {
        try {

            File printedStreamsAM = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_AM.txt");
            File printedStreamsPM = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_PM.txt");
            
            printedStreamsAM.createNewFile();
            printedStreamsPM.createNewFile();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
        A helper method for parseStreamGuysReportByDay()

        Creates the directory, PrintedUnsortedStreamLogs, that will hold two text files for each day that WAMU was streamed - YYYY-MM-DD_AM.txt and YYYY-MM-DD_PM.txt.
        
    */
    private static void createPrintedUnsortedDirectory() {
        try {
            File printedUnsortedStreamsDirectory = new File("./PrintedUnsortedStreamLogs");
        
            if (!printedUnsortedStreamsDirectory.exists()) {
                printedUnsortedStreamsDirectory.mkdir();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
        A helper method for parseStreamGuysReportByDay().

        Takes a WAMUStream as an argument and sorts it into the appropriate YYYY-MM-DD_AM.txt or YYYY-MM-DD_PM.txt file, depending on the date of the stream, and whether the stream was accessed before or after 12pm (noon).
    */
    private static void printStream(WAMUStream stream) {

        if (stream.getTimeForSort().getTimeForSort().compareTo(NOON) < 0) {
            try {
                File printedStreamDestination = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_AM.txt");
                FileWriter fileWriter = new FileWriter(printedStreamDestination, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.println(stream);
                printWriter.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                File printedStreamDestination = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_PM.txt");
                FileWriter fileWriter = new FileWriter(printedStreamDestination, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.println(stream);
                printWriter.close();
            } catch (Exception e) {
                System.out.println(e);
            }   
        }
    }

    /*
        Takes the name of the original Streamguys stream report as an argument. Writes that stream to the correct YYYY-MM-DD_AM.txt or YYYY-MM-DD_PM.txt file. 
        
    */
    public static void parseStreamGuysReportByDay(String fileName) {
        createPrintedUnsortedDirectory();
        
        try (Scanner scanner = new Scanner(Paths.get(fileName)).useDelimiter("\\t|\\n")) {

            while (scanner.hasNextLine()) {
                
                String ipAddress = scanner.next();
                String date = scanner.next();
                String time = scanner.next();
                String stream = scanner.next();
                String duration = scanner.next();
                String status = scanner.next();
                String referrer = scanner.next();
                
                WAMUStream streamObject = new WAMUStream(ipAddress, date, time, stream, duration, status, referrer);

                DaySorter.createOutputFiles(streamObject);
                DaySorter.printStream(streamObject);

            }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
