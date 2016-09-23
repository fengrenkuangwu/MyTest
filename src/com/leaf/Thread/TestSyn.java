package com.leaf.Thread;

import org.junit.Test;

import java.io.IOException;
import java.util.Hashtable;

/**
 * 测试同步代码块，利用对象给不同的业务加锁
 */

public class TestSyn {

    public static Hashtable<Integer,Integer> temp = new Hashtable<Integer,Integer>();
    final Mm mm =  new Mm();


    @Test
    public void test() throws InterruptedException, IOException {
        for(int i = 0; i<100; i++){
            System.out.println("for:"+i);
            new Thread() {
                public void run() {
                    synchronized (temp){
                        mm.add();
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    synchronized (temp){
                        //mm.show1();
                        //这两个处输出一定是一样的，因为和add是同步的，不能异步执行
                        mm.show();
                        mm.show();
                    }
                    System.out.println("------------------------");
                }
            }.start();

        }
        Thread.sleep(30000L);



    }

    class Mm{
        //Logger log = LoggerFactory.getLogger(Mm.class);
        int i = 0;

        void add(){
            System.out.println(Thread.currentThread().getName()+"-add");
            //log.info(Thread.currentThread().getName()+"-add");
            TestSyn.temp.put(i,i++);
        }
        void show(){
            //log.info(Thread.currentThread().getName()+"-show"+TestSyn.temp.toString());
            System.out.println(Thread.currentThread().getName()+"-show"+TestSyn.temp.toString());
        }
//        void show1(){
//            System.out.println(Thread.currentThread().getName()+"-"+1/(i%2));
//        }
    }
}
