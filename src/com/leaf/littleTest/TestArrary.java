package com.leaf.littleTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestArrary {
	public static Map<String,Object> map  = new HashMap<String,Object>();
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
	}
}
