import java.util.ArrayList;

public class StreamsByDate {

    private ArrayList<ReportingDate> streamsByDate;

    public StreamsByDate() {
        streamsByDate = new ArrayList<>();
    }

    public ArrayList<ReportingDate> getStreamsByDate() {
        return this.streamsByDate;
    }

    public void addStream(WAMUStream streamObject) {
        if (containsCorrespondingReportingDate(streamObject)) {
            for (ReportingDate list: streamsByDate) {
                if (streamObject.getDate().equals(list.getDate())) {
                    list.addStream(streamObject);
                    break;
                }
            }      
        } else {
            ReportingDate newReportingDate = new ReportingDate(streamObject.getDate());
            newReportingDate.addStream(streamObject);
            streamsByDate.add(newReportingDate);
        }
    }
    
    public boolean containsCorrespondingReportingDate(WAMUStream streamObject) {
        
        boolean containsReportingDate = false;
        for (ReportingDate list: streamsByDate) {
            if (streamObject.getDate().equals(list.getDate())) {
                containsReportingDate = true;
                break;
            }
        }

        return containsReportingDate;
    }

    public boolean isEmpty() {
        return streamsByDate.isEmpty();
    }

    public void printAllStreams() {
        for (ReportingDate reportingDate: streamsByDate) {
            reportingDate.printStreams();
        }
    }

    public String toString() {
        return streamsByDate.toString();
    }

}
