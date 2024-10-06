package com.practise.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SimpleExecutorService {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		Runnable r = ()-> {
			synchronized (new Thread()) {
			System.out.println("It's runnable");
			}
		};
		
		es.execute(new MyThread("A"));
        es.execute(new MyThread("B"));
        es.execute(new MyThread( "C"));
        es.execute(new MyThread("D"));
        es.execute(r);
        
        es.shutdown();

	}

}

class MyThread implements Runnable {
	 
    // Class data members
    String name;
    CountDownLatch latch;
 
    // Constructor
    MyThread( String name)
    {
 
        // this keyword refers to current instance itself
        this.name = name;
        //this.latch = latch;
 
        //new Thread(this);
    }
 
    // Method
    // Called automatically when thread is started
    public void run()
    {
 
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //latch.countDown();
        }
    }
}
