import java.util.Scanner;
import java.nio.file.Paths;

public class SoundExchange {
    public static void main(String[] args) {
        
        /*Run Block One to sort the StreamGuys log by day
        //
        */

        /*StreamPrinter.createPrintedUnsortedDirectory();
        //StreamsByDate streamsByDate = new StreamsByDate();
        
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

                StreamPrinter.createOutputFiles(streamObject);
                StreamPrinter.printStream(streamObject);

            }

            //streamsByDate.sortAllStreams();
            //streamsByDate.printAllStreams();
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        
        /*
            You should have generated unsorted AM and PM logs for each day, as a result of Block One
            For each unsorted AM or PM log, run:

            Run TimeSorter.createPrintedSortedDirectory as below

            Then, create a TimeSorter object for each unsorted AM or PM log, and
            run sortByTimeAndPrint("unsortedAMorPMlog.txt") on each one

            Below, I used a for loop to do that more quickly
        */
        /*TimeSorter.createPrintedSortedDirectory();
        
        for (int i = 10; i < 21; i++) {
            TimeSorter sorterAM = new TimeSorter();
            sorterAM.sortByTimeAndPrint("2021-06-" + i + "_AM.txt");
            TimeSorter sorterPM = new TimeSorter();
            sorterPM.sortByTimeAndPrint("2021-06-" + i + "_PM.txt");
        }*/
        
        

    }
}