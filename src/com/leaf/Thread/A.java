package com.leaf.Thread;

/**
 * Created by pekall on 16-11-26.
 */
public class A {

    static void alert(){
        System.out.println("alert method come in");
    }

    synchronized static void syn(){
        System.out.println("syn method begin");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syn method end");
    }
}
