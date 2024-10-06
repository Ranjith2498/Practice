package com.ThreadExecutorFramework;

import java.util.concurrent.*;

class Task2 implements Callable<String>{
	
	private String name;
	
	public Task2(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "hello "+name;
	}
	
	
}

public class ExecutorServiceFramework2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService es = Executors.newSingleThreadExecutor();
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		//Future is something like promise that it will give result
		Future<String> a = es.submit(new Task2("Ranjith"));
		
		//to get value using get() first previous step should completed
		String res = a.get();
		System.out.println(res);
		
		es.shutdown();
	}


}
