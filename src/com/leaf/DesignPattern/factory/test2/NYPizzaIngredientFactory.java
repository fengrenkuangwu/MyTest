package com.leaf.DesignPattern.factory.test2;

import com.leaf.DesignPattern.factory.test2.ingredient.Cheese;
import com.leaf.DesignPattern.factory.test2.ingredient.Clams;
import com.leaf.DesignPattern.factory.test2.ingredient.Dough;
import com.leaf.DesignPattern.factory.test2.ingredient.Pepperoni;
import com.leaf.DesignPattern.factory.test2.ingredient.Sauce;
import com.leaf.DesignPattern.factory.test2.ingredient.Veggies;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.FreshClams;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.Garlic;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.MarinaraSauce;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.Mushroom;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.Onion;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.RedPepper;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.ReggianoCheese;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.SlicedPepperoni;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.ThinCrustDough;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
