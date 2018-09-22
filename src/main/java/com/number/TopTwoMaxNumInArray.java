package com.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TopTwoMaxNumInArray {

	public static void main(String[] args) {
		Integer[] num={2,3,4,5,8,0,11,9};
		findTopTwoNum(num);
	}

	private static void findTopTwoNum(Integer[] num) {
		/*
		//sort arrays in descending order using any sorting algo
		int n= num.length;
		for (int i=0; i < n-1;i++){
			for (int j=0; j <n-1-i; j++) {
				if ( num[j] < num[j+1]) {
					int t=num[j+1];
					num[j+1]=num[j];
					num[j]=t;
				}
			}
		}
		System.out.println(num[0] +" "+num[1]);*/
		
		//or, Arrays.sort using a comparator or comparable
		//Arrays.sort(num, Collections.reverseOrder());		
		Arrays.sort(num, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}	
		});		
		System.out.println(num[0] +" "+num[1]);
	}
}
