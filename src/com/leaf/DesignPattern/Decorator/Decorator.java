package com.leaf.DesignPattern.Decorator;

/**
 * 定义装饰者
 * @author Leaf
 *
 */
public abstract class Decorator implements Human{
	private Human human;
	
	public Decorator(Human human){
		this.human = human;
	}

	@Override
	public void wearClothes() {
		human.wearClothes();
	}

	@Override
	public void walkToWhere() {
		human.walkToWhere();
	}

	
}
