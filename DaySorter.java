import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class DaySorter {

    public DaySorter() {}

    public static void createOutputFiles(WAMUStream stream) {
        try {

            File printedStreamsAM = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_AM.txt");
            File printedStreamsPM = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_PM.txt");
            
            printedStreamsAM.createNewFile();
            printedStreamsPM.createNewFile();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createPrintedUnsortedDirectory() {
        try {
            File printedUnsortedStreamsDirectory = new File("./PrintedUnsortedStreamLogs");
        
            if (!printedUnsortedStreamsDirectory.exists()) {
                printedUnsortedStreamsDirectory.mkdir();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printStream(WAMUStream stream) {
        LocalTime noon = LocalTime.NOON;
        if (stream.getTimeForSort().getTimeForSort().compareTo(noon) < 0) {
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

    public static void createArrayList(String fileName) {
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
