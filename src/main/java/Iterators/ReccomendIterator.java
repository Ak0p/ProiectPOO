package Iterators;

import Misc.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReccomendIterator implements LocIterator {


    private List<Streams> streams;
    private int index = 0;

    public ReccomendIterator(Map<Integer, Streams> map, Integer type, List<Integer> streamersList,
                             List<Integer> listenedStreams) {
        this.index = 0;
        this.streams = new ArrayList<>();
        for (Map.Entry<Integer, Streams> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue().getStreamType(), type) &&
                    streamersList.contains(entry.getValue().getStreamerId())
                    && !listenedStreams.contains(entry.getValue().getId())) {
                streams.add(entry.getValue());
            }
        }
        streams.sort((o1, o2) -> o2.getNoOfStreams().compareTo(o1.getNoOfStreams()));

    }

    @Override
    public boolean hasNext() {
        return index < streams.size();
    }

    @Override
    public Object getNext() {
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
