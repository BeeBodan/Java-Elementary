package com.bogdan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //Lesson #14

        /*
        1.) Создать список случайных чисел. Используя Stream Api подсчитать среднее арифиметическое квадратов этих чисел.
         */

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);

        System.out.println(list.stream().mapToInt(Integer::intValue).average());
    }
}