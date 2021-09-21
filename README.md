# SoundExchange
Place the raw streaming log file from StreamGuys in the top level of the SoundExchange repo.

If not already done, delete the row with the header fields (IP Address Date  Time  Stream  TLH  Status  Referrer) from the StreamGuys file. The first row needs to be the first row of data.

Open SoundExchange.java and paste the name of the streaming log file from StreamGuys in the parseStreamGuysReportByDay() method.

Run the program. It will run for about half an hour.

When finished, you should have a PrintedSortedStreamLogs directory with 28 logs sorted by date and time. Deliver that directory to the individual completing SoundExchange reporting for the quarter.
