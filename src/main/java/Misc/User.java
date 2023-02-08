package Misc;

import java.util.List;

public class User {

    public User(Integer id, String name, List<Integer> streams) {
        this.id = id;
        this.name = name;
        this.streams = streams;
    }

    private Integer id;

    private String name;

    private List<Integer> streams;

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

    public List<Integer> getStreams() {
        return streams;
    }

    public void setStreams(List<Integer> streams) {
        this.streams = streams;
    }
}
