package com.practise.DesignPattern;


class Example implements Cloneable{
	
	private String ip;
	private String importantData;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getImportantData() {
		return importantData;
	}
	public void setImportantData(String importantData) {
		this.importantData = importantData;
	}

	public void loadImportantData() throws InterruptedException {
		this.importantData = "Very very important data";
		Thread.sleep(5000);
	}
	
	@Override
	public String toString() {
		return ip +" : "+ importantData;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

public class ProtoType {
	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		
//		Note: Here we have used sleep() just to highlight if the first time object creation takes time, 
//		      cloned object will not take time to print bcoz its just a clone
		
		System.out.println("Creating object using prototype");
		
		Example ex = new Example();
		ex.setIp("192.168.1.1");
		ex.loadImportantData();
		
		System.out.println(ex);
		
		//we want new object of new connection
		Example ex2 = (Example) ex.clone();
		System.out.println(ex2);
		
		System.out.println(ex.hashCode());
		System.out.println(ex2.hashCode());
		
	}
}
