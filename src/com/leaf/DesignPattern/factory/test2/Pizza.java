package com.leaf.DesignPattern.factory.test2;


import com.leaf.DesignPattern.factory.test2.ingredient.Cheese;
import com.leaf.DesignPattern.factory.test2.ingredient.Clams;
import com.leaf.DesignPattern.factory.test2.ingredient.Dough;
import com.leaf.DesignPattern.factory.test2.ingredient.Pepperoni;
import com.leaf.DesignPattern.factory.test2.ingredient.Sauce;
import com.leaf.DesignPattern.factory.test2.ingredient.Veggies;

public abstract class Pizza {

	protected String name;
//	String dough;
//	String sauce;
	//ArrayList<String> toppings = new ArrayList<String>();
	
	
	//下面原料，原来的基础上新加
	protected Dough dough;
	protected Sauce sauce;
	protected Veggies veggies[];
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;
	
	//准备，新加
	protected abstract void prepare();
 
	//注销掉原来的准备方法
	/*void prepare() {
		System.out.println("Prepare " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings: ");
		for (String topping : toppings) {
			System.out.println("   " + topping);
		}
	}*/
  
	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
 
	void cut() {
		System.out.println("Cut the pizza into diagonal slices");
	}
  
	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
 
	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	
	//注销掉原来的方法
	/*public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (String topping : toppings) {
			display.append(topping + "\n");
		}
		return display.toString();
	}*/
	

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (clam != null) {
			result.append(clam);
			result.append("\n");
		}
		if (pepperoni != null) {
			result.append(pepperoni);
			result.append("\n");
		}
		return result.toString();
	}
}
