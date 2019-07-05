package com.bogdan;

public class Main {

    public static void main(String[] args) {
        //Lesson Two

        IntList newList = new IntArrayList();

        //Add (from the end)
        System.out.println("1) Add numbers in list:");
        newList.add(12);
        newList.add(24);
        newList.add(38);
        newList.add(21);
        newList.add(24);
        newList.add(101);
        newList.add(76);
        System.out.println(newList + "\n");

        //Add (index)
        System.out.println("2) Add number (65) in the middle list:");
        System.out.println(newList.add(5, 65));
        System.out.println(newList + "\n");

        //Get index
        System.out.println("3) Get number (index 2):");
        System.out.println(newList.get(2) + "\n");

        //Empty or not
        System.out.println("4) Empty or not:");
        System.out.println(newList.isEmpty() + "\n");

        //Remove (index)
        System.out.println("5) Remove number (index 2):");
        System.out.println(newList.remove(2));
        System.out.println(newList + "\n");

        //Remove (by value)
        System.out.println("6) Remove numbers (value 24):");
        System.out.println(newList.removeByValue(24));
        System.out.println(newList + "\n");

        //Set
        System.out.println("7) Set number 11 on 101:");
        System.out.println(newList.set(3, 11));
        System.out.println(newList + "\n");

        //Size
        System.out.println("8) Size list:");
        System.out.println(newList.size() + "\n");

        //Sublist
        System.out.println("9) List from 1 to 3 (inclusive!):");
        newList.subList(1, 3); //С 1 по 3 индекс включительно
        System.out.println(newList + "\n");

        //Clear
        System.out.println("10) Clear:");
        newList.clear();
        System.out.println(newList);
    }
}
