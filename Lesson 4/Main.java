package com.bogdan;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        //Lesson Fourth

        //=== IntList ===
        IntList list = new IntLinkedList();

        //Add (from the end)
        System.out.println("1) Add numbers in list:");
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(43);
        list.add(4);
        list.add(38);
        list.add(4);
        list.add(8);
        list.add(111);
        System.out.println(list + "\n");

        //Add (index)
        System.out.println("2) Add number (99) in the middle list:");
        System.out.println(list.add(3, 99));
        System.out.println(list + "\n");

        //Get index
        System.out.println("3) Get number (index 2):");
        System.out.println(list.get(2) + "\n");

        //Empty or not
        System.out.println("4) Empty or not:");
        System.out.println(list.isEmpty() + "\n");

        //Remove (index)
        System.out.println("5) Remove number (index 4):");
        System.out.println(list.remove(4));
        System.out.println(list + "\n");

        //Remove (by value)
        System.out.println("6) Remove numbers (value 4):");
        System.out.println(list.removeByValue(4));
        System.out.println(list + "\n");

        //Set
        System.out.println("7) Set number 8 on 48:");
        System.out.println(list.set(2,48));
        System.out.println(list + "\n");

        //Size
        System.out.println("8) Size list:");
        System.out.println(list.size() + "\n");

        //Sublist
        System.out.println("9) List from 2 to 5 (inclusive!):");
        list.subList(2, 5);
        System.out.println(list + "\n");

        //Clear
        System.out.println("10) Clear:");
        list.clear();
        System.out.println(list + "\n");

        //=== IntQueue ===
        IntQueue listQueue = new IntLinkedList();

        //Add (from the end)
        System.out.println("11) Add numbers in end Queue:");
        listQueue.add(7);
        listQueue.add(6);
        listQueue.add(34);
        listQueue.add(5);
        listQueue.add(55);
        System.out.println(listQueue + "\n");

        //Remove first element queue and return it
        System.out.println("12) Remove first element Queue and return it:");
        System.out.println(listQueue.remove());
        System.out.println(listQueue + "\n");

        //Return first element Queue
        System.out.println("13) Return first element Queue:");
        System.out.println(listQueue.element() + "\n");

        //=== IntStack ===
        IntStack listStack = new IntLinkedList();

        //Add (from the end)
        System.out.println("14) Add numbers on top Stack:");
        listStack.push(23);
        listStack.push(4);
        listStack.push(34);
        listStack.push(31);
        System.out.println(listStack + "\n");

        //Remove top element Stack and return it
        System.out.println("15) Remove top element Stack and return it:");
        System.out.println(listStack.pop());
        System.out.println(listStack + "\n");

        //Return top element Stack
        System.out.println("16) Return top element Stack:");
        System.out.println(listStack.peek()+ "\n");
    }
}
