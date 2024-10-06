package com.ThreadExecutorFramework;

import java.io.Serializable;
import java.util.concurrent.*;

class Task implements Runnable{
	
	private int number;
	
	public Task(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.print("\nTask "+number+" started" +""+Thread.currentThread().getName());
		for(int i=100*number;i<100*number+10;i++) {
			
			System.out.print(i+" ");
		}
		System.out.print("\nTask "+number+" end"+""+Thread.currentThread().getName());

	}
	
	
}

public class ExecutorServiceFramework implements Serializable  {

	public static void main(String[] args) {
//		ExecutorService es = Executors.newSingleThreadExecutor();
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.execute(new Task(1));
		es.execute(new Task(2));
		es.execute(new Task(3));
		es.execute(new Task(3));
		es.execute(new Task(3));

		es.shutdown();
	}


}
