package com.bogdan;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Lesson Fifth

        //Task 1
        System.out.println("Robot move:");
        System.out.println("1) " + moveRobot("UUURRDRDDDLLLU"));
        System.out.println("2) " + moveRobot("UUUDD"));
        System.out.println("3) " + moveRobot("UUUDDD") + "\n");

        //Task 2
        System.out.println(primeNumber(17));
        System.out.println(primeNumber(15));
        System.out.println(primeNumber(254) + "\n");

        //Task 3
        int[] newArr = new int[] {25, 6, 98, 67, 8, 3, 12, 23};
        System.out.println("Find number 12: " + search(newArr, 12) + "\n");

        //Task 4
        String arr = "abc";
        char[] chars = arr.toCharArray();
        reverse(chars, chars.length);

        betterReverse("", "abcd");
    }


    //Method for task 1
    private static boolean moveRobot(String move) {
        char[] chars = move.toCharArray();
        int countUpAndDown = 0, countLeftAndRight = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'U') { countUpAndDown++; }
            if (chars[i] == 'D') { countUpAndDown--; }
            if (chars[i] == 'R') { countLeftAndRight++; }
            if (chars[i] == 'L') { countLeftAndRight--; }
        }

        return countUpAndDown == 0 && countLeftAndRight == 0; //Correct!!!
    }

    //Method for task 2
    private static ArrayList<Integer> primeNumber(int number) {
        boolean check = false;
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                check = true;
                divisors.add(i);
            }
        }
        divisors.add(0, 1);
        divisors.add(number);

        if (!check) {
            System.out.println("Number " + number + " is prime");
        } else {
            System.out.println("Number " + number + " is not prime");
        }
        return divisors;
    }

    //Method for task 3
    private static boolean search(int[] arr, int number) {
        System.out.println(Arrays.toString(arr));
        sortBubble(arr);
        System.out.println(Arrays.toString(arr));
        String binaryNumberCode = Integer.toBinaryString(number);
        for (int i = 0; i < arr.length; i++) {
            String binaryArrCode = Integer.toBinaryString(arr[i]);
            if (binaryNumberCode.equals(binaryArrCode)) {
                return true;
            }
        }
        return false;
    }

    private static int[] sortBubble (int[] sortArr) {
        for (int i = sortArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortArr[j] > sortArr[j + 1]) {
                    int tmp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = tmp;
                }
            }
        }
        return sortArr;
    }

    //Method for task 4
    private static void reverse(char[] arr, int size) {
        if (size < 2) {
            System.out.println(arr);
        } else {
            for (int i = 0; i < size; i++) {
                swap(arr, i, size - 1); // abc - cba - bca(Output)
                reverse(arr, size - 1);
                swap(arr, size - 1, i); // bca - cba(Output) and i++
            }
        }
    }

    private static void swap(char[] arr, int j, int i) {
        char tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    //Method for task 4 (better)
    private static void betterReverse(String left, String right) {
        if (right.length() <= 1) {
            System.out.println(left + right);
        } else {
            for (char ch : right.toCharArray()) {
                betterReverse(left + ch, right.replace(String.valueOf(ch), ""));
            }
        }
    }
}
