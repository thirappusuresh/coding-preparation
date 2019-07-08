package com.mfino;

public class CountRunnableThread implements Runnable {
	public int count = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" Thread Started");
		while(count < 30) {
			if(count == 10 && Thread.currentThread().getName().equals("Hare")) {
				try {
					Thread.sleep(1000*10);
				} catch (InterruptedException e) {
					System.out.println("RunnableThread Interrupted "+e);
				}
			}
			count++;
			System.out.println(Thread.currentThread().getName()+" covered "+count+" meters");
		}
		System.out.println(Thread.currentThread().getName()+" Thread terminated");
	}
	
	public static void main(String[] args) {
		CountRunnableThread t = new CountRunnableThread();
		Thread thread = new Thread(t, "Tortoise");
		thread.start();
		
		CountRunnableThread t2 = new CountRunnableThread();
		Thread thread2 = new Thread(t2, "Hare");
		thread2.start();
	}
}
