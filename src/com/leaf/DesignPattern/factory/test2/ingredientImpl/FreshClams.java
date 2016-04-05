package com.leaf.DesignPattern.factory.test2.ingredientImpl;

import com.leaf.DesignPattern.factory.test2.ingredient.Clams;

/**
 * 这个包中的都是各种原材料，由厂家提供
 * @author Leaf
 *
 */
public class FreshClams implements Clams {

	public String toString() {
		return "Fresh Clams from Long Island Sound";
	}
}
