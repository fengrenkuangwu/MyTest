package com.leaf.InnerClass;

class Out {
	private int age = 12;
	
	class In{
		private int age = 13;
		public void print(){
			//public protected private 都不能用，为什么？为什么还能再次声明age
			int age = 14;
			System.out.println("局部变量：" + age);
            System.out.println("内部类变量：" + this.age);
            System.out.println("外部类变量：" + Out.this.age);
		}
	}
}

public class Demo {
    public static void main(String[] args) {
    	Out.In in = new Out().new In();
        in.print();
    }
}