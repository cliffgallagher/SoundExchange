public class SoundExchange {
    public static void main(String[] args) {
        
        /*
        //Run this block to sort the StreamGuys log by day
        */

        DaySorter.createPrintedUnsortedDirectory();
        DaySorter.createArrayList("filename.txt");
        

        
        /*
            You should have generated unsorted AM and PM logs for each day, as a result of the first
            two methods.
            
            Comment out the two functions above.

            Then, run:

            TimeSorter.createPrintedSortedDirectory()

            To create the destination file for the sorted logs. This is done in the commented section below.

            Then, create a TimeSorter object for each unsorted AM or PM log, and
            run sortByTimeAndPrint("unsortedAMorPMlog.txt") on each one. An example of this is also given below. I used a for loop to do that more quickly.
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
