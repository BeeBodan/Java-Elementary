package com.bogdan;

import java.util.Arrays;

public class MyHashSet implements MySet {

    private MyHashMap myMap = new MyHashMap();
    private String placeHolder = "";

    @Override
    public boolean add(String e) {
        return myMap.put(e, placeHolder) == null;
    }

    @Override
    public void clear() {
        myMap.clear();
    }

    @Override
    public boolean contains(String o) {
        return myMap.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return myMap.isEmpty();
    }

    @Override
    public boolean remove(String o) {
        if (myMap.containsKey(o)) {
            myMap.remove(o);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return myMap.size();
    }

    @Override
    public String[] toArray() {
        String[] result = new String[myMap.size()];
        int index = 0;
        for (MyMap.Entry entry : myMap.toArray()) {
            result[index++] = entry.getKey();
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
