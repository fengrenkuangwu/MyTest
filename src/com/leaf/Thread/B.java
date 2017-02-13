package com.leaf.Thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pekall on 16-11-26.
 * A 和 B 是一起的，在B中运行
 */
public class B {
    @Test
    public void test(){
        final CountDownLatch latch = new CountDownLatch(3);
        new Thread() {
            public void run() {
                A.syn();
                latch.countDown();
            }
        }.start();
        new Thread() {
            public void run() {
                A.alert();
                latch.countDown();
            }
        }.start();
        new Thread() {
            public void run() {
                A.syn();
                latch.countDown();
            }
        }.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
}
