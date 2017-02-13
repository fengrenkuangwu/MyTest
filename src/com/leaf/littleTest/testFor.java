package com.leaf.littleTest;

import java.util.ArrayList;
import java.util.List;

public class testFor {

	public static void main(String[] args) {
		//用null报空指针错误
		//List<String> as = null;
		//报空指针错误
		//List<String> as = (List)null;
		List<String> as = new ArrayList<>();
		for(String a :as){
			System.out.println(a);
		}
		System.out.println(as.size());
		System.out.println(null==as);
		
		List<String> bs = null;
		//System.out.println(bs.size());

        System.out.println("false".equals(false));

        System.out.println("012345678".substring(6));

		List<Integer> li = new ArrayList<>();
		for(int i = 1; i<=10; i++){
			li.add(i);
		}
		System.out.println(li.toString());
		for(Integer j : li){
			if(j%2 == 0){
				//不能直接这样，会报错
				//li.remove(j);
			}
		}
		System.out.println(li.toString());

	}

}
