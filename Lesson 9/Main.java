package com.bogdan;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    //Lesson Ninth

    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        /*
        * 1.) Есть документ со списком URL: https://drive.google.com/open?id=1wVBKKxpTKvWwuCzqY1cVXCQZYCsdCXTl
        * Вывести топ 10 доменов которые встречаются чаще всего. В документе могут встречается пустые и недопустимые строки.
        */

        try(FileReader fileReader = new FileReader("D://Programming//Java Projects//Java cource//Lesson 9//src//com//bogdan//url.txt"))
        {
            System.out.println("Top 10 urls: ");
            Scanner scanner = new Scanner(fileReader);
            scanner.useDelimiter("/");

            while(scanner.hasNext()) {
                String word = scanner.next();
                word = word.replaceAll(" ", "");
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);
                }
                scanner.nextLine();
            }
            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);
            Collections.reverse(list);
            list = list.subList(0, 10);

            for (int i = 0; i < 10; i++) {
                if (map.containsValue(list.get(i))) {
                    Object tmp = getKey(map, list.get(i)); //Method getKey
                    System.out.println(tmp + ": " + map.get(tmp));
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        /*
        * 3*) Вместо 2* сделать MyMap<K,V>
        */

        MyMapGeneric<Integer, Integer> myMap = new MyHashMapGeneric<>();
        myMap.put(11, 120);
        myMap.put(22, 130);
        myMap.put(33, 140);
        myMap.put(44, 150);
        System.out.println(myMap);

        MyMapGeneric<String, String> myMap2 = new MyHashMapGeneric<>();
        myMap2.put("1", "C++");
        myMap2.put("2", "Java");
        myMap2.put("3", "JS");
        myMap2.put("4", "Python");
        System.out.println(myMap2);

        System.out.println(myMap.isEmpty());
        System.out.println(myMap2.isEmpty());

        System.out.println(myMap.get(22));
        System.out.println(myMap2.get("2"));

        System.out.println(myMap.containsKey(33));
        System.out.println(myMap2.containsKey("4"));

        myMap.remove(22);
        System.out.println(myMap);
        myMap2.remove("2");
        System.out.println(myMap2);

        myMap.clear();
        System.out.println(myMap);
        myMap2.clear();
        System.out.println(myMap2);
    }

    //Method for task #1
    private static Object getKey(Map name, Object val) {
        for (Object o : name.keySet()) {
            if (name.get(o).equals(val)) {
                return o;
            }
        }
        return null;
    }
}
