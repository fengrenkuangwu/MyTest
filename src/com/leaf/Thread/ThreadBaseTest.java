package com.leaf.Thread;
/**
 * 简单的线程创建
 * @author Leaf
 * 线程并不会加快运行效率，反而会更慢，运行的速度是由cpu决定的
 * 而多线程快是因为多线程会占多个资源，比如下载，一个用户分配10k/s，而多线程则会被认为是多个人下载，获得了10k/s*多个线程
 */
public class ThreadBaseTest {

	public static void main(String[] args) {
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(true){
					System.out.println("1:"+Thread.currentThread().getName());
					System.out.println("2:"+this.getName());
				}
			}
		};
		thread1.start();
		
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(true){
					System.out.println("1:"+Thread.currentThread().getName());
				}
			}
		});
		thread2.start();
		
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(true){
					System.out.println("Runnable:"+Thread.currentThread().getName());
				}
			}
		}){
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(true){
					System.out.println("Thread:"+Thread.currentThread().getName());
				}
			};
		}.start();
	}

}
