package com.leaf.DesignPattern.Decorator;

/**
 * 定义被装饰者
 * @author Leaf
 *
 */
public interface Human {
	//穿衣服
	public void wearClothes();  
	//去哪
    public void walkToWhere();

    //与本测试没有关系，测试一下抽象类中是否可以有私有方法和具体方法
	//抽象类中不能有具体方法
    /*public void doDetail(){
    	System.out.println("我是一个具体方法");
	}*/
	//凑想类中不能有私有方法,因为具体方法都不能有，所以私有方法就没有任何意义
	//private void doSometing();
    //抽象类中的变量只能是public的
    int i = 1;
}
