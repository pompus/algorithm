package com.number;

public class CommonDivisorsOfTwoNumbers {

	public static void main(String[] args) {
		int num1=8, num2=40;
		printCommonFactors(num1,num2);
	}

	private static void printCommonFactors(int num1, int num2) {
		//number of times loop need to be run
		int n=1;
		
		if (num1 >num2) {
			n=num2;
		} else {
			n=num1;
		}
		
		for (int i=1; i<= n; i++) {
			if (num1 % i ==0 && num2 % i ==0) {
				System.out.println(i);
			}
		}		
	}
}
