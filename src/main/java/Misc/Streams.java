package Misc;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Streams implements Comparable {
    private transient Integer streamType;

    private transient Integer id;

    @SerializedName("id")
    private String idString;


    private transient Integer streamGenre;


    private transient Long noOfStreams;

    @SerializedName("noOfListenings")
    private String noOfListenings;

    private transient Integer streamerId;

    private transient Long length;

    @SerializedName("length")
    private String duration;

    private transient Long dateAdded;

    @SerializedName("dateAdded")
    private String date;

    public String getStreamerName() {
        return streamerName;
    }

    public void setStreamerName(String streamerName) {
        this.streamerName = streamerName;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String streamerName;


    public Streams(Integer streamType, Integer id, Integer streamGenre, Long noOfStreams, Integer streamerId, Long length, Long dateAdded, String name) {
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
        this.date = dateToString();
        this.duration = durationToString();
        this.idString = id.toString();
        this.noOfListenings = noOfStreams.toString();
    }

    public Integer getStreamType() {
        return streamType;
    }

    private String dateToString() {
//        Date date = new Date(dateAdded * 1000L);
//        Instant instant = date.toInstant().atZone(ZoneId.of("GMT")).toInstant();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        return formatter.format(instant);

        return Instant.ofEpochMilli(dateAdded * 1000L)
                .atZone(ZoneId.of("GMT"))
                .toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private String durationToString() {
        String timeInHHMMSS = "";
        long HH = length / 3600;
        long MM = (length % 3600) / 60;
        long SS = length % 60;
        if (HH == 0)
         timeInHHMMSS =  String.format("%02d:%02d", MM, SS);
        else
            timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
        return timeInHHMMSS;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStreamGenre() {
        return streamGenre;
    }

    public void setStreamGenre(Integer streamGenre) {
        this.streamGenre = streamGenre;
    }

    public Long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(Long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public Integer getStreamerId() {
        return streamerId;
    }

    public void setStreamerId(Integer streamerId) {
        this.streamerId = streamerId;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void listen() {
        this.noOfStreams++;
        this.noOfListenings = noOfStreams.toString();
    }

    private String name;


    @Override
    public int compareTo(Object o) {
        return this.getNoOfStreams().compareTo(((Streams)o).getNoOfStreams());
    }

}
