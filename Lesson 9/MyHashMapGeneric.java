package com.bogdan;

import java.util.Arrays;

public class MyHashMapGeneric<K, V> implements MyMapGeneric<K, V> {

    private static class HashMapEntry<K, V> implements MyMapGeneric.Entry<K, V> {

        private K key;
        private V value;
        private int hashCode;
        private HashMapEntry<K, V> next;

        private HashMapEntry(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    private int size = 0;
    private HashMapEntry[] table = new HashMapEntry[16];
    private double loadFactor = 0.75;
    private double threshold = loadFactor * table.length;

    @Override
    public Object put(K key, V value) {
        Object result = putInternal(key, value);
        if (result == null) {
            size++;
        }
        if (size > threshold) {
            resize();
        }
        return result;
    }

    private Object putInternal(K key, V value) {
        HashMapEntry newEntry = new HashMapEntry(key, value, key.hashCode());
        int position = newEntry.hashCode % table.length;
        if (table[position] != null) {
            HashMapEntry tmp = table[position];
            while (tmp != null) {
                if (tmp.key.equals(key)) {
                    Object oldValue = tmp.value;
                    tmp.value = value;
                    return oldValue;
                }
                tmp = tmp.next;
            }
            newEntry.next = table[position];
        }
        table[position] = newEntry;
        return null;
    }

        private void resize() {
        Entry[] arr = toArray();
        table = new HashMapEntry[table.length * 2];
        threshold = loadFactor * table.length;
        for (Entry entry : arr) {
            putInternal((K)entry.getKey(), (V)entry.getValue());
        }
    }

    @Override
    public K get(K key) {
        int hashKey = key.hashCode();
        int positionKey = hashKey % table.length;
        HashMapEntry tmp = table[positionKey];
        if (tmp != null) {
            return (K)tmp.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        int hashKey = key.hashCode();
        int positionKey = hashKey % table.length;
        HashMapEntry tmp = table[positionKey];
        while (tmp != null) {
            return key.equals(tmp.getKey());
        }
        return false;
    }

    @Override
    public K remove(K key) {
        Object value;
        if (containsKey(key)) {
            value = table[key.hashCode() % table.length].value;
            table[key.hashCode() % table.length] = null;
            size--;
            return (K)value;
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        size = 0;
        table = new HashMapEntry[16];
    }

    @Override
    public Entry[] toArray() {
        HashMapEntry[] result = new HashMapEntry[size];
        int index = 0;
        for (HashMapEntry tmp : table) {
            while (tmp != null) {
                result[index] = tmp;
                tmp = tmp.next;
                index++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
