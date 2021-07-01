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
        int reportingDateIndex = containsCorrespondingReportingDate(streamObject);
        if (reportingDateIndex > -1) { 
            streamsByDate.get(reportingDateIndex).addStream(streamObject);      
        } else {
            ReportingDate newReportingDate = new ReportingDate(streamObject.getDate());
            newReportingDate.addStream(streamObject);
            streamsByDate.add(newReportingDate);
        }
    }
    
    public int containsCorrespondingReportingDate(WAMUStream streamObject) {

        int reportingDateIndex = -1;
        for (ReportingDate list: streamsByDate) {
            if (streamObject.getDate().equals(list.getDate())) {
                reportingDateIndex = streamsByDate.indexOf(list);
                break;
            }
        }

        return reportingDateIndex;

    }

    public boolean isEmpty() {
        return streamsByDate.isEmpty();
    }

    public void sortAllStreams() {
        for (ReportingDate reportingDate: streamsByDate) {
            reportingDate.sort();
        }
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
