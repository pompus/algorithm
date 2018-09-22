package com.dynamic;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * 
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. LCS for
 * input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4. Because the LCS
 * function uses a "zeroth" element, it is convenient to define zero prefixes
 * that are empty for these sequences: R0 = Ø; and C0 = Ø. All the prefixes are
 * placed in a table with C in the first row (making it a column header) and R
 * in the first column (making it a row header).
 *
 */
public class LongestCommonSubsequence {

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs(char[] X, char[] Y, int m, int n) {
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	/* Utility function to get max of 2 integers */
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));
	}

}