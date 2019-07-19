package com.bogdan;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Lesson Sixth

        //===== HashMap =====
        MyMap myMap = new MyHashMap();

        //Put
        System.out.println("1) Put string:");
        myMap.put("1", "C");
        myMap.put("2", "Java");
        myMap.put("3", "JS");
        myMap.put("4", "HTML");
        myMap.put("1", "C++");
        System.out.println(myMap + "\n");

        //Empty or not
        System.out.println("2) Empty or not:");
        System.out.println(myMap.isEmpty() + "\n");

        //Size
        System.out.println("3) Size list:");
        System.out.println(myMap.size() + "\n");

        //Contain by key
        System.out.println("4) Contain by key:");
        System.out.println(myMap.containsKey("3") + "\n");

        //Get by key
        System.out.println("5) Get string by key:");
        System.out.println(myMap.get("2") + "\n");

        //Remove by key
        System.out.println("6) Remove string by key:");
        System.out.println(myMap.remove("4"));
        System.out.println(myMap + "\n");

        //Clear
        System.out.println("7) Clear:");
        myMap.clear();
        System.out.println(myMap + "\n");


        //===== HashSet =====
        MySet mySet = new MyHashSet();

        //Add
        System.out.println("1) Add string:");
        System.out.println(mySet.add("C++"));
        System.out.println(mySet.add("Java"));
        System.out.println(mySet.add("JS"));
        System.out.println(mySet.add("C++"));
        System.out.println(mySet + "\n");

        //Empty or not
        System.out.println("2) Empty or not:");
        System.out.println(mySet.isEmpty() + "\n");

        //Size
        System.out.println("3) Size list:");
        System.out.println(mySet.size() + "\n");

        //Contain by string
        System.out.println("4) Contain by string:");
        System.out.println(mySet.contains("Java") + "\n");

        //Remove by string
        System.out.println("5) Remove by string:");
        System.out.println(mySet.remove("JS"));
        System.out.println(mySet + "\n");

        //Clear
        System.out.println("6) Clear:");
        mySet.clear();
        System.out.println(mySet + "\n");


        //===== Alternative task =====

        /* Написать метод который принимает 2 строки - a, b. Метод должне вернуть количество символов которые у них различаются.
        Если строки разной длины то вернуть -1.
            Примеры:
            a="asdf", b="qwerty" => -1
            a="abb", b="bba" => 0
            a="abc", b="dca" => 1
            a="aaa", b="fga" => 2
            a="abc", b="dfg" => 3 */

        System.out.println("Alternative task:");
        System.out.println("asdf" + ", " + "qwerty" + " => " + compare("asdf", "qwerty"));
        System.out.println("abb" + ", " + "bba" + " => " + compare("abb", "bba"));
        System.out.println("abc" + ", " + "dca" + " => " + compare("abc", "dca"));
        System.out.println("aaa" + ", " + "fga" + " => " + compare("aaa", "fga"));
        System.out.println("abc" + ", " + "dfg" + " => " + compare("abc", "dfg"));
    }

    private static int compare(String a, String b) {
        int result;
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        if (a.length() != b.length()) {
            result = -1;
        } else {
            boolean[] boolCheckArr = new boolean[aChar.length];
            int count = 0;
            for (int i = 0; i < aChar.length; i++) {
                boolean check = false;
                for (int j = 0; j < bChar.length; j++) {
                    if (aChar[i] == bChar[j] && !boolCheckArr[j]) {
                        boolCheckArr[j] = true;
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    count++;
                }
            }
            result = count;
        }
        return result;
    }
}
