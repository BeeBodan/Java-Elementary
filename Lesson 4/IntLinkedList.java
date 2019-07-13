package com.bogdan;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {

        int value;
        Entry next;
        Entry previous;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first = null;
    private Entry last = null;

    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public int remove() {
        if (!isEmpty()) {
            Entry tmp = last;
            int firstElement = tmp.value;
            last = last.previous;
            size--;
            return firstElement;
        }
        return 0;
    }

    @Override
    public int element() {
        if (!isEmpty()) {
            Entry tmp = last;
            return tmp.value;
        }
        return 0;
    }

    @Override
    public boolean push(int value) {
        Entry newPush = new Entry(value);
        newPush.value = value;
        newPush.next = first;
        size++;
        first = newPush;
        return true;
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            Entry popEntry = getEntry(0);
            int result = popEntry.value;
            remove(0);
            return result;
        }
        return 0;
    }

    @Override
    public int peek() {
        if (!isEmpty()) {
            Entry popEntry = getEntry(0);
            int result = popEntry.value;
            return result;
        }
        return 0;
    }

    @Override
    public boolean add(int index, int element) {
        Entry tmp = first;
        Entry newEntry = new Entry(element);
        if (index < size && index >= 0) {
            if (index == 0) {
                tmp = newEntry;
                tmp.next = first;
                first = tmp;
            } else {
                for (int i = 0; i < size; i++) {
                    if (i == index - 1 && index != 0) {
                        newEntry.next = tmp.next;
                        tmp.next = newEntry;
                    }
                    tmp = tmp.next;
                }
            }
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int get(int index) {
        Entry tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
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
        Entry tmp = first;
        if (index < size) {
            if (index == 0) {
                first = first.next;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    tmp = tmp.next;
                }
                tmp.next = tmp.next.next;
            }
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;
        Entry tmp2;
        boolean check = false;
        while (tmp.next != null) {
            if (tmp.value == value) {
                first = first.next;
                size--;
                check = true;
            }
            if (tmp.next.value == value) {
                tmp2 = tmp.next;
                tmp.next = tmp2.next;
                size--;
                check = true;
            } else {
                tmp = tmp.next;
            }
        }
        return check;
    }

    @Override
    public boolean set(int index, int element) {
        if (index < size && index >= 0) {
            Entry tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            tmp.value = element;
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
        Entry tmp = first;
        Entry tmp2 = first;
        if (fromIndex == 0) {
            for (int i = 0; i < toIndex; i++) {
                tmp = tmp.next;
            }
        }

        if (fromIndex > 0) {
            for (int i = 0; i < size; i++) {
                if (i >= fromIndex && i <= toIndex) {
                    tmp2.next = tmp;
                    tmp2 = tmp2.next;
                }
                tmp = tmp.next;
            }
            remove();
        }
        size = (size - fromIndex) - (size - toIndex) + 1;
        return null;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private Entry getEntry (int index) {
        Entry tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
