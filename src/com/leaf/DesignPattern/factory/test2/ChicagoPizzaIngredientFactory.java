package com.leaf.DesignPattern.factory.test2;

import com.leaf.DesignPattern.factory.test2.ingredient.Cheese;
import com.leaf.DesignPattern.factory.test2.ingredient.Clams;
import com.leaf.DesignPattern.factory.test2.ingredient.Dough;
import com.leaf.DesignPattern.factory.test2.ingredient.Pepperoni;
import com.leaf.DesignPattern.factory.test2.ingredient.Sauce;
import com.leaf.DesignPattern.factory.test2.ingredient.Veggies;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.BlackOlives;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.Eggplant;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.FrozenClams;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.MozzarellaCheese;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.PlumTomatoSauce;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.SlicedPepperoni;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.Spinach;
import com.leaf.DesignPattern.factory.test2.ingredientImpl.ThickCrustDough;

public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
