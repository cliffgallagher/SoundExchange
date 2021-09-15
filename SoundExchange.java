public class SoundExchange {
    public static void main(String[] args) {
        
        /*
        /   1. Run parseStreamGuysReport() to sort the StreamGuys log by day. Save the StreamGuys log in the top level of the directory that you cloned this git to, and pass the filename as an argument to parseStreamGuysReport().
        */

        DaySorter.parseStreamGuysReport("filename.txt");
        

        
        /*
            2. You should have created 28 files (14 days of reporting for SoundExchange, each split by AM and PM) labeled YYYY-MM-DD_AM.txt and YYYY-MM-DD_PM.txt, sitting in the directory PrintedUnsortedStreamLogs. Those files contain the streams for each day, but unsorted by time.

        */

        /*

            3. Run:

            TimeSorter.createPrintedSortedDirectory()

            to create the destination file for the stream files that will be sorted by time.

            //TimeSorter.createPrintedSortedDirectory();

        */

        /*
            4.  

            To sort each of the files in PrintedUnsortedStreamLogs by time, you'll need to:

                a. create a TimeSorter object
                b. call the sortByTimeAndPrint() method on that object, and pass it the filename of one of the 28 files as an argument.
        
        */
        
        

    }
}
