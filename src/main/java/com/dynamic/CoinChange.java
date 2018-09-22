package com.dynamic;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=jaNZ83Q3QGc
 * https://www.youtube.com/watch?v=Y0ZqKpToTic
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2,
 * 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5}
 * and {5,5}. So the output should be 5.
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 6 };
		int m = arr.length;
		int n = 10;
		System.out.println(countWays(arr, m, n));
	}

	private static int countWays(int[] arr, int m, int n) {
		// table[i] will be storing the number of solutions for value i. We need
		// n+1 rows as the table is constructed in bottom up manner using the
		// base case (n = 0)
		int table[] = new int[n + 1];
		Arrays.fill(table, 0);

		// Base case - If given value is 0 then there is one solution which is 
		// (do not include any coin)
		table[0] = 1;

		// Pick all coins one by one and update the table[] values .
		// if current amount >= current coin, then table [amount-coin] added to table [j] 
		/*for (int i = 0; i < m; i++) {
			for (int j = arr[i]; j <= n; j++) {
				table[j] += table[j - arr[i]];
			}
		}
		*/
		for (int coin : arr) {
			for (int j=1; j<=n; j++) {
				if ( j >= coin) {
					table[j] += table[j - coin];
				}
			}
		}
		
		return table[n];
	}
}
