package com.bogdan;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Lesson Three


        //Task 1
        System.out.println(numJewelsInStones("aAbdYt", "cacacaadDaAY") + "\n");


        //Task 2
        int[] randomArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = -10 + random.nextInt(20);
        }
        System.out.println(Arrays.toString(randomArray));
        System.out.println(Arrays.toString(sort(randomArray)));
        System.out.println(Arrays.toString(square(randomArray)) + "\n");


        //Task 3
        String bigString = "#!Fhfh!RjsYYstg DDDd";
        System.out.println(bigString);
        char someStringChar [] = bigString.toCharArray();
        for (int i = 0; i < someStringChar.length; i++) {
            if (someStringChar[i] >= 65 && someStringChar[i] <= 90) {
                int tmp = (int)someStringChar[i] + 32;
                someStringChar[i] = (char) tmp;
            }
        }
        System.out.println(someStringChar);
    }


    //Method for task 1
    private static int numJewelsInStones(String jewels, String stones) {

        char jewelsChar [] = jewels.toCharArray();
        char stonesChar [] = stones.toCharArray();
        int count = 0;

        for (int i = 0; i < jewelsChar.length; i++) {
            for (int j = 0; j < stonesChar.length; j++) {
                if (jewelsChar[i] == stonesChar[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    //Method for task 2 (Method sorting and square)
    private static int[] sort (int[] Array) {

        for(int i = Array.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if( Array[j] > Array[j + 1] ) {
                    int tmp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = tmp;
                }
            }
        }
        return Array;
    }

    private static int[] square (int[] input) {

        int[] output = new int[10];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i] * input[i];
        }
        sort(output);
        return output;
    }
}
