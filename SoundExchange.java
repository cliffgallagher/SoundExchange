import java.io.File;

public class SoundExchange {
    public static void main(String[] args) {
        
        /*
        /   1. Run parseStreamGuysReportByDay() to sort the StreamGuys log by day. Save the StreamGuys log in the clone you've forked from GitHub, and pass the filename of the StreamGuys log as an argument to parseStreamGuysReport().
        */

        DaySorter.parseStreamGuysReportByDay("NO EXCEL WAMU 2021 Q3 Stream.csv");
        

        
        /*
            2. You should have created 28 files (14 days of reporting for SoundExchange, each split by AM and PM) labeled YYYY-MM-DD_AM.txt and YYYY-MM-DD_PM.txt, sitting in the directory PrintedUnsortedStreamLogs. Those files contain the streams for each day, but unsorted by time.

        */

        /*

            3. Run:

            TimeSorter.createPrintedSortedDirectory()

            to create the destination file for the stream files that will be sorted by time.
        */

            TimeSorter.createPrintedSortedDirectory();

        

        /*
            4.  

            The loop below creates an array of File objects out of the 28 stream logs (unsorted by time) in the PrintedUnsortedStreamLogs directory.

            It creates a TimeSorter object for each log, and uses that objects sortByTimeAndPrint() method to sort each log by time and place it in PrintedSortedStreamLogs.

            When the process is complete, hand the PrintedSortedStreamLogs directory off to the person compiling the logs for SoundExchange.
        
        */
        
        File printedUnsortedDirectory = new File("./PrintedUnsortedStreamLogs");
        File[] directoryListing = printedUnsortedDirectory.listFiles();

        for (File file: directoryListing) {
            TimeSorter sorter = new TimeSorter();
            sorter.sortByTimeAndPrint(file.getName());
        }
        

    }
}
