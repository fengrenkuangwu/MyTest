package com.leaf.DesignPattern.Observer.test1;

/**
 * 主题(被观察者)接口
 * 不使用java提供的观察者库，自己实现
 * @author Leaf
 * @date 2016年3月29日12:52:35
 */
public interface Subject {
	//注册一个观察者
	public void registerObserver(Observer o);
	//删除一个观察者
	public void removeObserver(Observer o);
	//当主题改变状态时，这个方法被调用以通知所有观察者
	public void notifyObservers();
}
