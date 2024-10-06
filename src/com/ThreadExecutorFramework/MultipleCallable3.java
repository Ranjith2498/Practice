package com.ThreadExecutorFramework;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task3 implements Callable<String>{
	
	private String name;
	
	public Task3(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "hello "+name+" "+Thread.currentThread().getName();
	}
	
	
}

public class MultipleCallable3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService es = Executors.newSingleThreadExecutor();
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		List<Task3> futureList = List.of(new Task3("Ranjith"),new Task3("Tejas"),new Task3("Rahul"));
		
//		InvokeAll will waits for all task to be complete then invokes
		List<Future<String>> a = es.invokeAll(futureList);
		
		for(Future<String> res : a) {
			System.out.println(res.get());
		}
		System.out.println();

		
		//invokeAny waits if any one task complete, as soon as it completes it provides single value
		String a1 = es.invokeAny(futureList);
		System.out.println(a1);
		
		es.shutdown();
	}

}
