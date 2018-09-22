package com.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a value V, if we want to make change for V Rs, and we have infinite
 * supply of each of the denominations in Indian currency, i.e., we have
 * infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued
 * coins/notes, what is the minimum number of coins and/or notes needed to make
 * the change?
 *
 */
public class MinumumNumberOfCoins {

	public static void main(String[] args) {
		// Greedy Algorithm. Start from largest possible denomination and keep
		// adding denominations while remaining value is greater than 0
		int n = 493;
		System.out.println(numberOfCoins(n));
	}

	private static int numberOfCoins(int n) {
		List<Integer> result = new ArrayList<>();

		int denominators[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		int l = denominators.length;

		int numberOfCoints = 0;

		for (int i = l - 1; i >= 0; i--) {
			if (denominators[i] <= n) {
				result.add(denominators[i]);
				n -= denominators[i];
				i++;
				numberOfCoints++;
			}
		}
		System.out.println(result);
		return numberOfCoints;
	}
}
