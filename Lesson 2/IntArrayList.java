package com.bogdan;

import java.util.Arrays;

public class IntArrayList implements IntList {

    private int[] arr = new int[10];
    private int size = 0;

    @Override
    public void add(int element) {
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1;
            int[] newArr = new int[newSize];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        if (index < size && index >= 0) {
            if (size >= arr.length) {
                int newSize = arr.length * 3 / 2 + 1;
                int[] newArr = new int[newSize];
                for (int i = 0; i < size; i++) {
                    newArr[i] = arr[i];
                }
                arr = newArr;
            }
            System.arraycopy(arr, index, arr, index + 1, size - index);

            arr[index] = element;
            size++;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        size = 0;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean remove(int index) {
        if (index < size) {
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByValue(int value) {
        boolean check = false; // проверка для вывода отчета
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                size--;
                i--;
                check = true;
            }
        }
        return check;
    }

    @Override
    public boolean set(int index, int element) {
        if (index < size && index >= 0) {
            arr[index] = element;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        int newSize = arr.length;
        int[] newArr = new int[newSize];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i >= fromIndex && i <= toIndex) { // включительно
                newArr[j] = arr[i];
                j++;
            }
        }
        size = (size - fromIndex) - (size - toIndex) + 1;
        arr = newArr;
        return null;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}