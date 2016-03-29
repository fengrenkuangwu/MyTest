package com.leaf.DesignPattern.Strategy;

/**
 * 演示调用
 * @author Leaf
 *
 */
public class Zhaoyun {

	public static void main(String[] args) {
		//环境，也可能是一个对象
		Context context;

		System.out.println("----------刚到吴国使用第一个锦囊---------------");
		//对象的做某个行为的不同做法（把不同的具体实现传进去）
		context = new Context(new FirstStrategy());
		context.operate();
		System.out.println("\n");

		System.out.println("----------刘备乐不思蜀使用第二个锦囊---------------");
		context.setStrategy(new SecondStrategy());
		context.operate();
		System.out.println("\n");

		System.out.println("----------孙权的追兵来了，使用第三个锦囊---------------");
		context.setStrategy(new ThirdStrategy());
		context.operate();
		System.out.println("\n");

	}

}
