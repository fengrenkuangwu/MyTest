package com.leaf.DesignPattern.Decorator;

public class Test {

	public static void main(String[] args) {
		Human a = new Person();
		a = new DecoratorFirst(a);
		a = new DecoratorSecond(a);
		a = new DecoratorThird(a);
		a.wearClothes();
		
		Human b = new DecoratorThird(new DecoratorSecond(new DecoratorFirst(new Person())));
		b.walkToWhere();
	}

}
