public class WAMUStream {
    private String ipAddress;
    private String date;
    private String time;
    private String stream;
    private String duration;
    private String status;
    private String referrer;

    public WAMUStream(String ipAddress, String date, String time, String stream, String duration, String status, String referrer) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.time = time;
        this.stream = stream;
        this.duration = duration;
        this.status = status;
        this.referrer = referrer;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public String toString() {
        return "ipAddress: " + ipAddress + ", date: " + date + ", time: " + time + ", stream: " + stream + ", duration: " + duration + ", status: " + status + ", referrer: " + referrer;
    }
}