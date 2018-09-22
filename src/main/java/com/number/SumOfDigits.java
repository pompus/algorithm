package com.number;

public class SumOfDigits {

	public static void main(String[] args) {
		int number=259;
		System.out.println(sumOfNumbers(number));
	}

	private static int sumOfNumbers(int number) {
		if (number==0)
			return 0;
		else 
			return (number % 10)+ sumOfNumbers(number/10);
	}
}
