package com.bogdan;

public class Main {

    public static void main(String[] args) {

        String[] word = {"b", "gin", "zen", "b", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(word));
    }

    private static int uniqueMorseRepresentations(String[] word){

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        StringBuilder stringBuilder = new StringBuilder();
        String[] arrString = new String[word.length];
        int index = 0, count = 0;

        for (String s : word) {
            for (int j = 0; j < s.length(); j++) {
                System.out.println(morse[find(s.charAt(j))]);
                stringBuilder.append(morse[find(s.charAt(j))]);
            }
            arrString[index] = stringBuilder.toString();
            index++;
            stringBuilder.setLength(0);
        }
        for (int i = 0; i < arrString.length; i++) {
            for (int j = i + 1; j < arrString.length; j++) {
                if (arrString[i].equals(arrString[j])){
                    count++;
                }
            }
        }
        return count;
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