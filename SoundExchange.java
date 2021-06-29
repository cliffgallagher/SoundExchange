import java.util.Scanner;
import java.nio.file.Paths;

public class SoundExchange {
    public static void main(String[] args) {
        
        StreamsByDate streamsByDate = new StreamsByDate();
        
        try (Scanner scanner = new Scanner(Paths.get("streaming_data.csv")).useDelimiter("\\t|\\n")) {

            while (scanner.hasNextLine()) {
                
                String ipAddress = scanner.next();
                String date = scanner.next();
                String time = scanner.next();
                String stream = scanner.next();
                String duration = scanner.next();
                String status = scanner.next();
                String referrer = scanner.next();
                
                WAMUStream streamObject = new WAMUStream(ipAddress, date, time, stream, duration, status, referrer);
                streamsByDate.addStream(streamObject);

            }

            System.out.println("all added");

            streamsByDate.sortAllStreams();
            streamsByDate.printAllStreams();
            
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}