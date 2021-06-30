import java.util.Scanner;
import java.nio.file.Paths;

public class SoundExchange {
    public static void main(String[] args) {
        
        StreamPrinter.createPrintedUnsortedDirectory();
        //StreamsByDate streamsByDate = new StreamsByDate();
        
        try (Scanner scanner = new Scanner(Paths.get("streaming_data_first_quarter.csv")).useDelimiter("\\t|\\n")) {

            while (scanner.hasNextLine()) {
                
                String ipAddress = scanner.next();
                String date = scanner.next();
                String time = scanner.next();
                String stream = scanner.next();
                String duration = scanner.next();
                String status = scanner.next();
                String referrer = scanner.next();
                
                WAMUStream streamObject = new WAMUStream(ipAddress, date, time, stream, duration, status, referrer);

                StreamPrinter.createOutputFiles(streamObject);
                StreamPrinter.printStream(streamObject);

            }

            //streamsByDate.sortAllStreams();
            //streamsByDate.printAllStreams();
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}