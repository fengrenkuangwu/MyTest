package com.leaf.DesignPattern.Strategy;

/**
 * 实现类（ConcreteStrategy）
 * 不同的行为，不同的实现
 * 变化多的 实现过程 抽出来，作为算法族，算法族之间可以互相替换
 * @author Leaf
 *
 */
public class FirstStrategy implements Strategy {

	@Override
	public void operate() {
		System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备");
	}
}
