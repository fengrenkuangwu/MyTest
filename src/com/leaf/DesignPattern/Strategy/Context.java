package com.leaf.DesignPattern.Strategy;

/**
 * 环境类（Context)
 * 使用构造函数，把需要的行为导入，或者创建抽象的父类和子类，子类中使用构造函数，确定父类的不同行为（算法族）
 * @author Leaf
 *
 */
public class Context {
	private Strategy strategy;
	
	public Context (Strategy st){
		this.strategy = st;
	}


	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void operate(){
		strategy.operate();
	}
}
