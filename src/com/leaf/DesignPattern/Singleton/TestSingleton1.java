package com.leaf.DesignPattern.Singleton;

/**
 * 饿汉式单例类.在类初始化时，已经自行实例化   
 * @author Leaf
 *
 */
public class TestSingleton1 {
	//构造函授私有化
	private TestSingleton1(){
		
	}
	private static final TestSingleton1 singleton = new TestSingleton1();
	 //静态工厂方法   
    public static TestSingleton1 getInstance() {  
        return singleton;  
    }
    
    //下面无关，用来测试构造函数私有化，和testSingleton中的new一起测试
    class Aa{
    	int a = 0;
    	private Aa(int b){
    		a=b;
    	}
    	private Aa(){
    		
    	}
    }
    
    class Bb{
    	Aa aa = new Aa();
    }
}

