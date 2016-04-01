package com.leaf.DesignPattern.Decorator;

/**
 * 下面定义三种装饰，这是第一个，第二个第三个功能依次细化，即装饰者的功能越来越多
 * @author Leaf
 *
 */
public class DecoratorFirst extends Decorator{

	public DecoratorFirst(Human human) {
		super(human);
	}

	public void goHome() {  
        System.out.println("进房子。。");  
    }  
  
    public void findMap() {  
        System.out.println("书房找找Map。。");  
    }

	@Override
	public void wearClothes() {
		//先执行以下父类中的这个方法，从代码上说不执行是不会报错
		super.wearClothes();
		//自己添加其他行为，也就是装饰，比如给咖啡中再加入别的辅料
		goHome();
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		findMap();
	}
    
}
