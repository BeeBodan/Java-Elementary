package com.bogdan;

public class Main {

    public static void main(String[] args) {
        //Lesson One

        //Part One
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.print("Hello ");
            }
            if (i % 5 == 0 && i % 3 != 0) {
                System.out.print("World ");
            }
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.print("HelloWorld ");
            }
            if (i % 3 != 0 & i % 5 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print("\n\n");


        //Part Two
        int numbers[] = new int[10];
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) Math.round((Math.random() * 10) + 10);
            System.out.print(numbers[i] + " ");
            sum += numbers[i];
        }
        sum = sum / 10;
        System.out.println("\nAverage: " + sum + "\n\n");


        //Part Three
        System.out.println(string());
    }

    private static String string() {
        StringBuilder numbersString = new StringBuilder("Numbers: ");
        for(int i = 1; i <= 30; i++){
            numbersString.append("(" + i + ") ");
        }
        return numbersString.toString();
    }
}