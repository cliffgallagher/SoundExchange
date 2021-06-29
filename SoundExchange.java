import java.util.Scanner;
import java.nio.file.Paths;

public class SoundExchange {
    public static void main(String[] args) {
        
        StreamsByDate streamsByDate = new StreamsByDate();
        ReportingDate june7 = new ReportingDate("2021-06-07");
        
        try (Scanner scanner = new Scanner(Paths.get("sample_data.txt")).useDelimiter("\\t|\\n")) {

            // we read the file until all lines have been read
            while (scanner.hasNextLine()) {
                /*String row = scanner.nextLine();
                System.out.println(row);*/
                
                String ipAddress = scanner.next();
                String date = scanner.next();
                String time = scanner.next();
                String stream = scanner.next();
                String duration = scanner.next();
                String status = scanner.next();
                String referrer = scanner.next();
                
                WAMUStream streamObject = new WAMUStream(ipAddress, date, time, stream, duration, status, referrer);
                //System.out.println(streamObject);
                streamsByDate.addStream(streamObject);

                june7.addStream(streamObject);

            }

            //System.out.println(streamsByDate);
            System.out.println(june7.size());
            june7.printStreams();
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}