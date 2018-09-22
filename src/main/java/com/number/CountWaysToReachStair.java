package com.number;

/**
 * There are n stairs, The person can climb either 1 stair or 2 stairs at a
 * time. Count the number of ways, the person can reach the top
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 *
 */
public class CountWaysToReachStair {

	public static void main(String[] args) {
		// here, need to find fibonaci(n+1) using recursion or dynamic
		// programming where n is the total steps and
		// m is the number of stairs can be crossed at a time
		int n = 4, m = 3;
        System.out.println("Nuber of ways = " + CountWaysToReachStair(n, m));
	}

	private static int CountWaysToReachStair(int n, int m) {
		return CountWaysToReachStairUtil(n+1,m);
	}

	private static int CountWaysToReachStairUtil(int n, int m) {
		if (n<=1)
			return n;
		int result=0;
		for (int i=1; i<=m && i<=n;i++)
			result+=CountWaysToReachStairUtil(n-i,m);
		return result;
	}
}
