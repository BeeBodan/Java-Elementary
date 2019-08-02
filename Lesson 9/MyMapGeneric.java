package com.bogdan;

public interface MyMapGeneric<K, V> {

    interface Entry<K, V> {
        K getKey();
        V getValue();
        void setValue(V value);
    }

    Object put(K key, V value);

    K get(K key);

    boolean containsKey(K key);

    K remove(K key);

    int size();

    boolean isEmpty();

    void clear();

    Object[] toArray();
}
