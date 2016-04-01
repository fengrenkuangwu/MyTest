package com.leaf.DesignPattern.Decorator;

public class DecoratorSecond extends Decorator{

	public DecoratorSecond(Human human) {
		super(human);
	}

	public void goClothespress() {  
        System.out.println("去衣柜找找看。。");  
    }  
  
    public void findPlaceOnMap() {  
        System.out.println("在Map上找找。。");  
    }

	@Override
	public void wearClothes() {
		super.wearClothes();
		goClothespress();
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		findPlaceOnMap();
	}  
    
    
}
