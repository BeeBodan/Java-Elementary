package com.bogdan;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Lesson Seventh

        /*
        * 1. Создать 2мерный массив (матрица) M*N и заполнить его случайными числами. Отсортировать
        * числа по возрастанию, чтобы с левом верхнем углу было самое маленькое число, справа от него
        * следующее по значению, итд, в правом нижнем углу самое большое.
        */

        int row = 6, column = 10;
        int[][] doubleArr = new int[row][column];

        //Fill array random numbers
        Random random = new Random();
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[i].length; j++) {
                doubleArr[i][j] = random.nextInt(100) + 1;
            }
        }

        System.out.println("No sort array:");
        for (int[] a : doubleArr) {
            printRow(a);
        }

        //int[][] -> int[]
        int[] arr = new int[row * column];

        int tmp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[tmp++] = doubleArr[i][j];
            }
        }
        Arrays.sort(arr);
        System.out.println();

        //int[] -> int[][]
        tmp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                doubleArr[i][j] = arr[tmp++];
            }
        }

        System.out.println("Sort array:");
        for (int[] a : doubleArr) {
            printRow(a);
        }
        System.out.println();

        /*
         * 2. Задан текстовый файл. Вывести сколько в нём:
         * a) строк
         * b) слов
         * c) символов
         */

        try(FileReader reader = new FileReader("D://Programming//Java Projects//Java cource//Lesson 7//src//com//bogdan//TaskTwo.txt"))
        {
            Scanner scanner = new Scanner(reader);
            int lines = 0;
            int chars = 0;
            int words = 0;

            while (scanner.hasNextLine()) {

                lines++;

                String line = scanner.nextLine();

                chars += line.length();

                words += new StringTokenizer( line, " ").countTokens();
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Chars: " + chars);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        /*
         * 3. Задана строка с датой вида "22.01.2019 19:15:00". Написать метод который преобразовывает ее
         * в формат "22 Jan, 7:15 PM". Предусмотреть обработку ситуации если входящая дата в недопустимом формате.
         */

        String string = "22.01.2019 19:15:00";
        newString(string);
        System.out.println();

        /*
         * 4. Есть List объектов у каждого из которых 2 поля: int и String. Удалить те у которых значения int
         * повторяются(оставить по одному из дубликатов).
         */

        Item s1 = new Item(1, "C++");
        Item s2 = new Item(2, "Java");
        Item s3 = new Item(3, "JS");
        Item s4 = new Item(4, "Python");
        Item s5 = new Item(1, "C++");
        Item s6 = new Item(2, "C++");

        List<Item> all = new ArrayList<>();
        all.add(s1);
        all.add(s2);
        all.add(s3);
        all.add(s4);
        all.add(s5);
        all.add(s6);

        for (int i = 0; i < all.size(); i++) {
            for (int j = i + 1; j < all.size(); j++) {
                if (all.get(i).num == all.get(j).num) {
                    all.remove(j);
                }
            }
        }

        Iterator iter = all.iterator();
        while (iter.hasNext()) {
            Item item = (Item)iter.next();
            System.out.println(item.num + " " + item.name);
        }
        System.out.println();

        /*
         * 5. Есть фрагмент кода, который при запуске выдает ошибку NullPointerException. Найдите и исправьте ошибку:
         */

        Board board = new Board();
        System.out.println(board.count());
    }



    //Method for task #1
    private static void printRow(int[] a) {
        for (int i : a) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    //Method for task #3
    private static void newString(String str) {

        String newStr = str.replaceAll("[^0-9]+","");

        if (newStr.length() != 14) {
            System.out.println("You entered incorrect data!");
        } else {
            String[] allMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

            int day = conversion(newStr, 0, 2);
            int month = conversion(newStr, 2, 4);
            int year = conversion(newStr, 4, 8);
            int hour = conversion(newStr, 8, 10);
            int min = conversion(newStr, 10, 12);
            int sec = conversion(newStr, 12, 14);

            if (day > 31 || month > 12 || hour > 24 || min > 60 || sec > 60) {
                System.out.println("You entered incorrect data!");
            } else {
                String meridiem;
                if (hour < 12) {
                    meridiem = "AM";
                } else {
                    hour = hour - 12;
                    meridiem = "PM";
                }
                System.out.println(day + " " + allMonth[month - 1] + " " + year + ", " + hour + ":" + min + " " + meridiem);
            }
        }
    }

    private static int conversion(String str, int a, int b) {
        int output = Integer.parseInt(str.substring(a, b));
        return output;
    }

    //Method for task #4
    private static class Item {
        int num;
        String name;

        public Item(int num, String name) {
            this.num = num;
            this.name = name;
        }
    }

    //Method for task #5
    private static class Ball {
    }

    private static class Board {
        private List<Ball> balls = new ArrayList<>();

        public Board() {
            //List balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());
        }

        public int count() {
            return balls.size();
        }
    }
}