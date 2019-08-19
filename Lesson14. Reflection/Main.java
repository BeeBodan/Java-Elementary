package com.bogdan;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws Exception {

        User user = new User("Bob", 22);

        String methodName = "";

        methodName = "getName";
        Method getNameMethod = user.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(user);
        System.out.println(name);

        methodName = "getAge";
        Method getAgeMethod = user.getClass().getMethod(methodName);
        int age = (int) getAgeMethod.invoke(user);
        System.out.println(age);

        methodName = "setName";
        Method setNameMethod = user.getClass().getMethod(methodName, String.class);
        setNameMethod.invoke(user, "Alex");

        methodName = "setAge";
        Method setAgeMethod = user.getClass().getMethod(methodName, int.class);
        setAgeMethod.invoke(user, 33);

        System.out.println(user);
    }
}