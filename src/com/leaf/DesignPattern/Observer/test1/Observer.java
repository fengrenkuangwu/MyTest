package com.leaf.DesignPattern.Observer.test1;

/**
 * 观察者接口，所有的观察者必须实现观察者接口
 * @author Leaf
 *
 */
public interface Observer {
	public void update(float temperature,float humidity,float pressure);
}
