package com.practise.DesignPattern;

abstract class Vehicle {
 public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
 public void printVehicle() {
     System.out.println("I am two wheeler");
 }
}

class FourWheeler extends Vehicle {
 public void printVehicle() {
     System.out.println("I am four wheeler");
 }
}

//This class is like a factory class helps in calling object of child class 
class Client {
 private Vehicle pVehicle;

 public Client(int type) {
     if (type == 1) {
         pVehicle = new TwoWheeler();
     } else if (type == 2) {
         pVehicle = new FourWheeler();
     } else {
         pVehicle = null;
     }
 }

 public Vehicle getVehicle() {
     return pVehicle;
 }
}


public class Factory {

	public static void main(String[] args) {
//   Note : when there is super class and multiple subclass and we want object of subclass based on input and requirement 		
		
//   Note : The Factory Method Design Pattern is a creational design pattern that provides an interface for 
//		    creating objects in a superclass, allowing subclasses to alter the type of objects that will be created. 
//		    It encapsulates object creation logic in a separate method, promoting loose coupling between the creator 
//		    and the created objects. This pattern is particularly useful when the exact types of objects to be created 
//		    may vary or need to be determined at runtime, enabling flexibility and extensibility in object creation.
		
//		if we use like this its a tight couple, everytime we have tp change code if we have to change
//		Vehicle v = new TwoWheeler();
		
		 Client pClient = new Client(1);
		 Vehicle pVehicle = pClient.getVehicle();
		 if (pVehicle != null) {
		     pVehicle.printVehicle();
		 }
	}
}
