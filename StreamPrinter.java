import java.io.File;
import java.io.PrintWriter;

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
    
}
