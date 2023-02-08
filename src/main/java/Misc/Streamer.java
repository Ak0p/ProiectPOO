package Misc;

public class Streamer {

    private Integer streamerType;

    private Integer id;

    private String name;

    public Integer getStreamerType() {
        return streamerType;
    }

    public void setStreamerType(Integer streamerType) {
        this.streamerType = streamerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Streamer(Integer streamerType, Integer id, String name) {
        this.streamerType = streamerType;
        this.id = id;
        this.name = name;
    }


}
