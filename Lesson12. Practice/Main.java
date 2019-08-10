package com.bogdan;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        //Lesson #12

        //Task #1
        System.out.println(reverse("man has dog"));

        int[][] arr = {
                {1,2,5},
                {2,3},
                {1,3,4,7}
        };

        //Task #2
        Iterator iterator = new Iterator(arr);
        List<Integer> list = new ArrayList<>();

        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.sort(list);
        System.out.println(list);
    }


    public static String reverse(String s){
        Scanner scanner = new Scanner(s);
        Stack<String> stack = new Stack<>();
        String str = "";
        int size = 0;

        scanner.useDelimiter(" ");
        while (scanner.hasNext()){
            String word = scanner.next();
            stack.push(word);
            size++;
        }
        for (int i = 0; i < size; i++) {
            str += stack.pop() + " ";
        }

        return str.trim();
    }
}
