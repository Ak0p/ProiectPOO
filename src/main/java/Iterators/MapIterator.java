package Iterators;

import Iterators.LocIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapIterator<K, V> implements LocIterator {

    private List<Map.Entry<K, V>> entries;
        private int index = 0;
        private int keyIndex = 0;


        public MapIterator(Map<K, V> map) {
            index = 0;
            entries = new LinkedList<>();
            entries.addAll(map.entrySet());
        }

        @Override
        public boolean hasNext() {
            return index < entries.size();
        }

        @Override
        public V getNext() {
            return entries.get(index++).getValue();
        }


        @Override
        public K getNextKey() {
            return entries.get(keyIndex++).getKey();
        }

        @Override
        public void reset() {
            index = 0;
            keyIndex = 0;
        }



}
