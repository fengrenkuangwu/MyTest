package com.leaf.littleTest;

import java.lang.reflect.Field;

/**
 * Created by pekall on 17-2-10.
 * 一个关于int的面试题
 */
public class TestInt {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a, b);//需要在调用method方法之后，仅打印出啊a=100，b=200,请写出method的方法代码
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    private static void method(int a, int b) {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c;
        try {
            c=cache.getDeclaredField("cache");
            c.setAccessible(true);
            Integer[] array = (Integer[]) c.get(cache);
            System.out.println(array[138]);
            System.out.println(array[148]);
            array[138] = 100;
            array[148] = 200;
            System.out.println(array[138]);
            System.out.println(array[148]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*private static void method(int a, int b) {
        System.out.println("a=100");
        System.out.println("a=200");
        System.exit(0);
    }*/
}
