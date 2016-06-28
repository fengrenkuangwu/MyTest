package com.leaf.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ThaditionalTimerTest {

	private static int i = 0;
	public static void main(String[] args) {
		/*new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing");
				
			}
		}, 10000,3000);*/
		
		
		class MyTimerTast extends TimerTask{
			
			@Override
			public void run() {
				i = (i+1)%2;
				System.out.println("bombing");
				new Timer().schedule(new MyTimerTast(), 2000+2000*i);
			}
			
		}
		
		
		new Timer().schedule(new MyTimerTast(), 2000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
