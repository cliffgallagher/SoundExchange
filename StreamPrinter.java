import java.io.File;
import java.io.PrintWriter;

public class StreamPrinter {

    public StreamPrinter() {}

    public static void printStream(WAMUStream stream) {
        try {
            
            File printedUnsortedStreamsDirectory = new File("./PrintedUnsortedStreamLogs");
            if (!printedUnsortedStreamsDirectory.exists()) {
                printedUnsortedStreamsDirectory.mkdir();
            }
            
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
    
}
