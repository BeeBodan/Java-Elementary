package com.bogdan;

public class Iterator {

    private final int[][] arr;
    private int indexI;
    private int indexJ;

    public Iterator(int[][] arr) {
        this.arr = arr;
    }

    public boolean hasNext() {

        return indexI < arr.length && indexJ < arr[indexI].length;
    }

    public int next() {

        int num = arr[indexI][indexJ];
        indexJ++;

        while (indexI < arr.length && indexJ >= arr[indexI].length) {
            indexJ = 0;
            indexI++;
        }
        return num;
    }
}
