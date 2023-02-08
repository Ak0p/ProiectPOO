package Misc;

import Iterators.LocIterator;
import Iterators.MapIterator;
import Iterators.ReccomendIterator;
import Iterators.SurpriseIterator;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RequestHandler {

    private static RequestHandler instance = null;

    private RequestHandler() {
        this.db = Database.getInstance();
        this.output = new StringBuilder();
    }

    public static RequestHandler getInstance() {
        if (RequestHandler.instance == null) {
            RequestHandler.instance = new RequestHandler();
        }
        return RequestHandler.instance;
    }

    private Database db;
    private StringBuilder output;


    public void add(Integer streamerId, Integer streamType, Integer id, Integer streamGenre, Long length, String name) {

        Long dateAdded = System.currentTimeMillis() / 1000L;
        Long noOfStreams = 0L;
        Streams streams = new Streams(streamType, id, streamGenre, noOfStreams, streamerId, length, dateAdded, name);
        db.getStreams().put(id, streams);

    }

    public void list(Integer id) {
        StringBuilder json = new StringBuilder();


        List<Streams> streamsList = new LinkedList<>();
        Gson gson = new Gson();
        Integer objectType = db.objectTypeById(id);
        if (objectType == 1) {


            LocIterator it = new MapIterator(db.getStreams());
            while (it.hasNext()) {
                Streams streams = (Streams) it.getNext();
                if (streams.getStreamerId().equals(id)) {
                    streamsList.add(streams);
                }
            }


        } else if (objectType == 3) {
            User user = db.getUsers().get(id);
            List<Integer> streamIds = user.getStreams();
            for (Integer streamId : streamIds) {
                streamsList.add(db.getStreams().get(streamId));
            }
        }

        json.append(gson.toJson(streamsList));
        output.append(json).append("\n");
    }

    public void listen(Integer userId, Integer streamId) {
        User user = db.getUsers().get(userId);
        if (!user.getStreams().contains(streamId))
            user.getStreams().add(streamId);

        Streams streams = db.getStreams().get(streamId);
        streams.listen();
    }

    public void recommend(Integer userId, Integer streamType) {

        User user = db.getUsers().get(userId);
        List<Streams> recommendedStreams = new ArrayList<>(5);
        List<Integer> listenedStreamers = new LinkedList<>();

        for (Integer streamId : user.getStreams()) {
            Streams streams = db.getStreams().get(streamId);
            if (!listenedStreamers.contains(streams.getStreamerId())) {
                listenedStreamers.add(streams.getStreamerId());
            }
        }

        LocIterator it = new ReccomendIterator(db.getStreams(), streamType, listenedStreamers, user.getStreams());


        for (int i = 0; i < 5 && it.hasNext(); i++) {
            recommendedStreams.add((Streams) it.getNext());
        }
        Gson gson = new Gson();
        String json = gson.toJson(recommendedStreams);
        output.append(json).append("\n");
    }

    public void surprise(Integer userId, Integer streamType) {

        User user = db.getUsers().get(userId);
        List<Streams> surpriseStreams = new ArrayList<>(3);
        List<Integer> listenedStreamers = new LinkedList<>();

        for (Integer streamId : user.getStreams()) {
            Streams streams = db.getStreams().get(streamId);
            if (!listenedStreamers.contains(streams.getStreamerId())) {
                listenedStreamers.add(streams.getStreamerId());
            }
        }

        LocIterator it = new SurpriseIterator(db.getStreams(), streamType, listenedStreamers);


        for (int i = 0; i < 3 && it.hasNext(); i++) {
            surpriseStreams.add((Streams) it.getNext());
        }

        Gson gson = new Gson();
        String json = gson.toJson(surpriseStreams);

        output.append(json).append("\n");

    }

    public void showOutput() {
        System.out.println(output.toString());
    }

    public void reset() {
        output = new StringBuilder();
    }

    public void delete(Integer streamid) {
        db.getStreams().remove(streamid);
    }
}
