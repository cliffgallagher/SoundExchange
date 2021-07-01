import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.time.LocalTime;

public class StreamPrinter {

    public StreamPrinter() {}

    public static void createOutputFiles(WAMUStream stream) {
        try {

            File printedStreamsAM = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_AM.txt");
            File printedStreamsPM = new File("./PrintedUnsortedStreamLogs/" + stream.getDate() + "_PM.txt");
            
            printedStreamsAM.createNewFile();
            printedStreamsPM.createNewFile();
            
            /*File outputLogFiles = new File("./Output Log Files");
            if (!outputLogFiles.exists()) {
                outputLogFiles.mkdir();
            }
            File printedStreams = new File("./Output Log Files/" + getDate() + ".txt");
            printedStreams.createNewFile();
            PrintWriter writer = new PrintWriter(printedStreams);
            for (WAMUStream stream: streams) {
                writer.println(stream);
            }
            writer.close();*/
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
    
}
