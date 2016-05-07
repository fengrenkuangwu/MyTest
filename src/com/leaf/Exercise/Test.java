package com.leaf.Exercise;



public class Test {
	private int j=0;
	
	private synchronized void jia(){
		j++;
		System.out.println("当前线程："+Thread.currentThread().getName()+"该线程要加，j="+j);
	}
	private synchronized void jian(){
		j--;
		System.out.println("当前线程："+Thread.currentThread().getName()+"该线程要减，j="+j);
	}
	
	public static void main(String arg[]){
		Test t = new Test();
		ThreadJia threadJia = t.new ThreadJia();
		ThreadJian threadJian = t.new ThreadJian();
//		Thread a;
		for (int i = 0; i < 2; i++) {
			Thread a = new Thread(threadJia);
			a.start();
			a=new Thread(threadJian);
			a.start();
		}
		
	}
	
	class ThreadJia implements Runnable{
		@Override
		public void run() {
			jia();
		}
		
	}
	
	class ThreadJian implements Runnable{
		@Override
		public void run() {
			jian();
		}
		
	}

}
