package com.leaf.algorithm;

public class SplitFind {

	/**
     * 功   能：折半查找
	 * @author leaf
	 * @param arrayData 数组
	 * @param searchData 要查找的数据
	 * @param start 开始下标
	 * @param end 结束下标
	 * @return 数据在数组中下标的位置，如果数据不在数组中，返回 -1
	 */
	public static int splitHalf(int[] arrayData,int searchData,int start,int end){
		int index = (start + end)/2;
		int data = arrayData[index];
		if(start > end ){
			return -1;
		}
		if(data == searchData){
			return index;
		}else{
			if(data < searchData){
				return splitHalf(arrayData,searchData,index+1,end);
			}else{
				return splitHalf(arrayData,searchData,start,index-1);
			}
		}
	}
	
	/**
	 * @author leaf
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 3,5,11,17,21,23,28,30,32,50};
		System.out.println(array.length);
		int isExist = splitHalf(array,(int)50,0,array.length - 1);
		System.out.println("isExist : "+isExist);
	}

}
