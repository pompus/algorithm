package com.number;

public class SumOf1st1000Prime {

	public static void main(String[] args) {
		System.out.println(summationOfPrimes(1000));
	}

	private static int summationOfPrimes(int n) {
		int i = 1;
		int initialNumber = 2;
		int sum = 0;
		while (i <= n) {
			boolean isPrime = true;
			for (int j = 2; j <= initialNumber / 2; j++) {
				if (initialNumber % j == 0) {
					isPrime=false;
					break;
				}
			}
			if (isPrime) {
				sum += initialNumber;
				i++;
			}
			initialNumber++;
		}
		return sum;
	}
}
