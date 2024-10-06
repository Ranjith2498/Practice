package com.practise.DesignPattern;

interface Icecream{
	 public void getIcecreamName();
}

class VanillaCupIcecream implements Icecream{
	@Override
	public void getIcecreamName() {
		System.out.println("vanilla cup icecream");
	}
}

class StrawberryCupIcecream implements Icecream{
	@Override
	public void getIcecreamName() {
		System.out.println("Strawberry cup icecream");		
	} 
}


class VanillaBrickIcecream implements Icecream{
	@Override
	public void getIcecreamName() {
		System.out.println("vanilla Brick icecream");
	}
}

class StrawberryBrickIcecream implements Icecream{
	@Override
	public void getIcecreamName() {
		System.out.println("Strawberry Brick icecream");		
	} 
}

abstract class AbstractIcecreamFactory{
	public abstract Icecream getIcecreamByType(IcecreamEnum iceCreamEnum);
}

enum IcecreamEnum{
	VANILLA,STRAWBERRY
}

class CupIcecreamFactory extends AbstractIcecreamFactory{
	@Override
	public Icecream getIcecreamByType(IcecreamEnum iceCreamEnum) {
		// TODO Auto-generated method stub
		if(iceCreamEnum ==IcecreamEnum.VANILLA) {
			return new VanillaCupIcecream();
		}
		else if(iceCreamEnum ==IcecreamEnum.STRAWBERRY){
			return new StrawberryCupIcecream();
		}
		else {
			return null;
		}
	}
}

class BrickIcecreamFactory extends AbstractIcecreamFactory{
	@Override
	public Icecream getIcecreamByType(IcecreamEnum iceCreamEnum) {
		// TODO Auto-generated method stub
		if(iceCreamEnum ==IcecreamEnum.VANILLA) {
			return new VanillaBrickIcecream();
		}
		else if(iceCreamEnum ==IcecreamEnum.STRAWBERRY){
			return new StrawberryBrickIcecream();
		}
		else {
			return null;
		}
	}
}

public class AbstractFactory {

	public static void main(String[] args) {
		
//		The Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other. 
//		It provides a set of rules or instructions that let you create different types of things without knowing exactly what 
//		those things are. This helps you keep everything organized and lets you switch between different types easily, following 
//		the same set of rules.
//
//		Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over 
//		factory pattern.
//		Abstract Factory patterns work around a super-factory which creates other factories.
//		Abstract factory pattern implementation provides us with a framework that allows us to create objects that follow a 
//		general pattern.
//		So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.
		
		AbstractIcecreamFactory cupFactory = new CupIcecreamFactory();
		VanillaCupIcecream vp = (VanillaCupIcecream) cupFactory.getIcecreamByType(IcecreamEnum.VANILLA);
		vp.getIcecreamName();
		
		StrawberryCupIcecream sp = (StrawberryCupIcecream) cupFactory.getIcecreamByType(IcecreamEnum.STRAWBERRY);
		sp.getIcecreamName();
		
		
		AbstractIcecreamFactory brickFactory = new BrickIcecreamFactory();
		VanillaBrickIcecream vb = (VanillaBrickIcecream) brickFactory.getIcecreamByType(IcecreamEnum.VANILLA);
		vp.getIcecreamName();
		
		StrawberryBrickIcecream sb = (StrawberryBrickIcecream) brickFactory.getIcecreamByType(IcecreamEnum.STRAWBERRY);
		sp.getIcecreamName();
	}
}
