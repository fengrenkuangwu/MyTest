package com.leaf.DesignPattern.factory.test2;

import com.leaf.DesignPattern.factory.test2.ingredient.Cheese;
import com.leaf.DesignPattern.factory.test2.ingredient.Clams;
import com.leaf.DesignPattern.factory.test2.ingredient.Dough;
import com.leaf.DesignPattern.factory.test2.ingredient.Pepperoni;
import com.leaf.DesignPattern.factory.test2.ingredient.Sauce;
import com.leaf.DesignPattern.factory.test2.ingredient.Veggies;

/**
 * 生产披萨原料的工厂
 * @author Leaf
 *
 */
public interface PizzaIngredientFactory {
	//接口中，每个原料都有一个对应的方法创建该原料
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
