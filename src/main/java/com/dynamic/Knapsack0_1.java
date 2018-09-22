package com.dynamic;

/**
 * https://www.youtube.com/watch?v=nLmhmB6NzcM
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * 
 * To consider all subsets of items, there can be two cases for every item: (1)
 * the item is included in the optimal subset, (2) not included in the optimal
 * set. Therefore, the maximum value that can be obtained from n items is max of
 * following two values. 1) Maximum value obtained by n-1 items and W weight
 * (excluding nth item). 2) Value of nth item plus maximum value obtained by n-1
 * items and W minus weight of the nth item (including nth item).
 * 
 * If weight of nth item is greater than W, then the nth item cannot be included
 * and case 1 is the only possibility.
 */
public class Knapsack0_1 {

	public static void main(String[] args) {
		// this is not required to be sorted
		int val[] = new int[] { 1, 4, 5, 7 };
		// this has to be in sorted order. If its not in sorted, you need to
		// sort it and change val array accordingly
		int wt[] = new int[] { 1, 3, 4, 5 };
		int W = 7;
		int n = val.length; // or, wt.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int n) {
		int i, j;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		// 1st row or column should be 0 as it means there is no capacity or
		// weight is 0.
		// i means row of table = given weights 1, 3, 4, 5
		for (i = 0; i <= n; i++) {
			// j is number of columns = 0, 1, 2, 3,...W different weights =>
			// capacity
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					K[i][j] = 0;
				} else if (wt[i - 1] > j) {
					// it means we have to exclude wt[i-1] as it is more than
					// capacity
					K[i][j] = K[i - 1][j];
				} else {
					// max of cases( wt[i-1] is included and when not included)
					K[i][j] = Math.max(val[i - 1] + K[i - 1][j - wt[i - 1]], K[i - 1][j]);
				}
			}
		}
		return K[n][W];
	}
}
