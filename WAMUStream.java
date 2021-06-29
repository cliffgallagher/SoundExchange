public class WAMUStream implements Comparable<WAMUStream> {
    private String ipAddress;
    private String date;
    private String time;
    private TimeForSort timeForSort;
    private String stream;
    private String duration;
    private String status;
    private String referrer;

    public WAMUStream(String ipAddress, String date, String time, String stream, String duration, String status, String referrer) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.time = time;
        this.timeForSort = new TimeForSort(this.time);
        this.stream = stream;
        this.duration = duration;
        this.status = status;
        this.referrer = referrer;
    }

    public String getDate() {
        return this.date;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public TimeForSort getTimeForSort() {
        return this.timeForSort;
    }

    @Override
    public int compareTo(WAMUStream other) {
        return getTimeForSort().compareTo(other.getTimeForSort());
    }

    public String toString() {
        //return "ipAddress: " + ipAddress + ", date: " + date + ", time: " + time + ", stream: " + stream + ", duration: " + duration + ", status: " + status + ", referrer: " + referrer;
        return ipAddress + "\t" + date + "\t" + time + "\t" + stream + "\t" + duration + "\t" + status + "\t" + referrer; 
    }
}