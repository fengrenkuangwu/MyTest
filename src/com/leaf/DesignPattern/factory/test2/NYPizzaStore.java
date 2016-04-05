package com.leaf.DesignPattern.factory.test2;

import com.leaf.DesignPattern.factory.test2.pizza.CheesePizza;
import com.leaf.DesignPattern.factory.test2.pizza.ClamPizza;
import com.leaf.DesignPattern.factory.test2.pizza.PepperoniPizza;
import com.leaf.DesignPattern.factory.test2.pizza.VeggiePizza;

/**
 * 工厂方法，使用继承，创建对象的方法在父类中是抽象的，创建对象的方法重写实现。
 * @author Leaf
 *
 */
public class NYPizzaStore extends PizzaStore{

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
			new NYPizzaIngredientFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		} else if (item.equals("clam")) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
 
		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		return pizza;
	}

}
