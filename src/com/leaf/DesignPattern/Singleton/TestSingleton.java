package com.leaf.DesignPattern.Singleton;

import com.leaf.DesignPattern.Singleton.TestSingleton1.Aa;

/**
 * 懒汉单例，需要的时候才开始创建实例
 * @author Leaf
 *
 */
public class TestSingleton {

	//如果用static 将内部类静态化，那么内部类就只能访问外部类的静态成员变量，具有局限性
	private static class LazyHolder{
		private static final TestSingleton instance= new TestSingleton();
	}
	private TestSingleton(){
		
	}
	public static final TestSingleton getInstance(){
		return LazyHolder.instance;
	}
	
	
	//下面无关，用来测试构造函数私有化，和testSingleton1中的类一起测试，私有化后类不能new出来
	//Aa aa = TestSingleton1.getInstance().new Aa(1);
}
