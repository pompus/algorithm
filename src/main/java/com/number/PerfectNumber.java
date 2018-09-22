package com.number;

/**
 * A perfect number is a positive integer that is equal to the sum of its proper
 * positive divisors, that is, the sum of its positive divisors excluding the
 * number itself. Equivalently, a perfect number is a number that is half the
 * sum of all of its positive divisors. The first perfect number is 6, because
 * 1, 2 and 3 are its proper positive divisors, and 1 + 2 + 3 = 6. Equivalently,
 * the number 6 is equal to half the sum of all its positive divisors: ( 1 + 2 +
 * 3 + 6 ) / 2 = 6.
 */
public class PerfectNumber {

	public static void main(String[] args) {
		printPerfect(6);
		printPerfect(8);
	}

	private static void printPerfect(int perfect) {
		int result = 0;
		for (int i = 1; i <= perfect / 2; i++) {
			if (perfect % i == 0)
				result += i;
		}
		if (result == perfect) {
			System.out.println(perfect + " is perfect number");
		} else {
			System.out.println(perfect + " is not perfect number");
		}
	}
}
