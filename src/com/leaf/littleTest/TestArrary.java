package com.leaf.littleTest;

import org.junit.Test;

import java.util.*;

public class TestArrary {
	public static Map<String,Object> map  = new HashMap<String,Object>();
	public static List<Integer> list = new ArrayList<>();
	public static int int_a = 1;
	public static int int_b = 2;
	static{
		list.add(int_a);
		list.add(int_b);
	}

	public static void main(String[] args){
		int[] array = new int[]{1,2,3};
		System.out.println(Arrays.asList(array));
		
		Integer[] array1 = new Integer[]{1,2,3};
		System.out.println(Arrays.asList(array1));



		map.put("a",new Object());
		map.put("b",new Object());

		System.out.println(null == map.get("a"));
		System.out.println(null == map.get("aa"));
		System.out.println(map.get("a") == map.get("b"));
		System.out.println(map.get("a"));

		System.out.println("list.contains(new Integer(1))："+list.contains(new Integer(1)));
		System.out.println("list.contains(new Integer(1))："+list.contains(1));
		System.out.println("list.contains(new Integer(1))："+list.contains(new Integer(3)));

	}

	/**
	 * 测试List的contains是通过什么判断的
	 *
	 * 如果不重写的Ha的hash和equals方法，返货false
	 * 如果按照一下方法重写了，返回true
	 * 说明contains方法是通过equals去判断的
	 */
	@Test
	public void test(){
		List<Ha> hh = new ArrayList<>();
		Ha ha = new Ha();
		ha.setA(1);
		ha.setB("2");
		hh.add(ha);

		Ha hb = new Ha();
		hb.setA(1);
		hb.setB("2");

		System.out.println(hh.contains(hb));
	}

	class Ha{
		Integer a;
		String b;

		public Integer getA() {
			return a;
		}

		public void setA(Integer a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Ha ha = (Ha) o;

			if (a != null ? !a.equals(ha.a) : ha.a != null) return false;
			return b != null ? b.equals(ha.b) : ha.b == null;

		}

		@Override
		public int hashCode() {
			int result = a != null ? a.hashCode() : 0;
			result = 31 * result + (b != null ? b.hashCode() : 0);
			return result;
		}
	}
}
