package com.mfino;

public class CountThread extends Thread {
	private int count;
	CountThread(int count) {
		this.count = count;
	}
	
	public void run() {
		System.out.println("start: "+count);
		while(count < 10) {
			try {
				count++;
				System.out.println("Count: "+count);
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end: "+count);
	}
	
	public static void main(String args[]) {
		CountThread t1 = new CountThread(2);
		CountThread t2 = new CountThread(3);
		t1.start();
		t2.start();
	}
}
