package Iterators;

public interface LocIterator<K, V> {

    public boolean hasNext();

    public V getNext();
    public K getNextKey();


    public void reset();


}
