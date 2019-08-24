package com.bogdan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        String[] word = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        System.out.println(uniqueMorseRepresentations(word));
    }

    private static int uniqueMorseRepresentations(String[] word){

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        StringBuilder stringBuilder = new StringBuilder();
        String[] arrString = new String[word.length];
        int index = 0;

        for (String s : word) {
            for (int j = 0; j < s.length(); j++) {
                stringBuilder.append(morse[find(s.charAt(j))]);
            }
            arrString[index] = stringBuilder.toString();
            index++;
            stringBuilder.setLength(0);
        }
        Set<String> set = new HashSet<>(Arrays.asList(arrString));
        return set.size();
    }

    private static int find(char h){
        int index = 0;
        for (char c = 'a'; c < 'z'; c++) {
            index++;
            if (c == h){
                index--;
                break;
            }
        }
        return index;
    }
}