package com.leaf.DesignPattern.factory.test2.pizza;

import com.leaf.DesignPattern.factory.test2.Pizza;
import com.leaf.DesignPattern.factory.test2.PizzaIngredientFactory;

/**
 * 不同种类的披萨
 * @author Leaf
 *
 */
public class CheesePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	protected void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
