package com.leaf.littleTest;

import org.junit.Test;

/**
 * Created by pekall on 17-2-7.
 */
public class TestWhile {

    @Test
    public void test1(){
        int i = 0;
        System.out.println("开始。。。");
        while(true){
            if(i==5){
               break;
            }
            i++;
            System.out.println(i);
        }
        System.out.println("结束。。。");

        synchronized (TestWhile.class){
            System.out.println("waiceng。。。");
            synchronized (TestWhile.class){
                System.out.println("neiceng。。。");
            }
            haha();
            System.out.println("结束。。。");
        }
    }

    synchronized void haha(){
        System.out.println("haha。。。");
    }
}
