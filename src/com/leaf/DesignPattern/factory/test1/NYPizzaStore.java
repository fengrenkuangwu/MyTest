package com.leaf.DesignPattern.factory.test1;

/**
 * 工厂方法，使用继承，创建对象的方法在父类中是抽象的，创建对象的方法重写实现。
 * @author Leaf
 *
 */
public class NYPizzaStore extends PizzaStore{

	@Override
	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}

}
