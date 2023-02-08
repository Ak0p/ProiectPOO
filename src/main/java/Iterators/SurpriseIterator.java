package Iterators;

import Iterators.LocIterator;
import Misc.RequestHandler;
import Misc.Streams;

import java.util.*;

public class SurpriseIterator implements LocIterator{

    private List<Streams> streams;
    private int index = 0;

    public SurpriseIterator(Map<Integer, Streams> map, Integer type, List<Integer> streamersList) {
        this.index = 0;
        streams = new ArrayList<>();
        for (Map.Entry<Integer, Streams> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue().getStreamType(), type) && !streamersList.contains(entry.getValue().getStreamerId())) {
                streams.add(entry.getValue());
                RequestHandler.write("Adaug in lista " + entry.getValue().getId());
            }
        }
        streams.sort((o1, o2) -> {
            Date d1 = new Date(o1.getDateAdded() * 1000L);
            Date d2 = new Date(o2.getDateAdded() * 1000L);
            if (d1.before(d2)) {
                return 1;
            } else if (d1.after(d2)) {
                return -1;
            } else {
                return o2.getNoOfStreams().compareTo(o1.getNoOfStreams());
            }
        });

        for (Streams stream : streams) {
            RequestHandler.write("streams " + stream.getNoOfStreams() + " " + stream.getId() +
                    " " + stream.getDate() + " " + stream.getNoOfStreams());
        }

    }

    @Override
    public boolean hasNext() {
        return index < streams.size();
    }
    @Override
    public Object getNext() {
        RequestHandler.write("index " + index + " id " + streams.get(index).getId());
        return streams.get(index++);
    }

    @Override
    public Object getNextKey() {
        return null;
    }

    @Override
    public void reset() {
        index = 0;
    }

}
