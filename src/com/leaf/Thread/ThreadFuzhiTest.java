package com.leaf.Thread;

/**
 * Created by pekall on 17-2-6.
 * 线程赋值测试
 */
public class ThreadFuzhiTest implements Runnable{

    private Boolean flag = true;

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("进入线程...");
        while (flag){
            //加下面的语句可以跳出循环
            //System.out.println("...");
            if(!flag){
                break;
            }
        }
        System.out.println("退出线程...");

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFuzhiTest threadFuzhiTest = new ThreadFuzhiTest();
        new Thread(threadFuzhiTest).start();
        Thread.sleep(2000);
        threadFuzhiTest.setFlag(false);
        System.out.println("flag已经改成false...");
    }
}
