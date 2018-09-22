package com.number;

/**
 * A palindromic number or numeral palindrome is a number that remains the same
 * when its digits are reversed. Like 16461, for example, it is "symmetrical"
 *
 */
public class PalindromesInRange {

	public static void main(String[] args) {
		printPalindromes(10, 103);
	}

	private static void printPalindromes(int i, int j) {
		for (int t = i; t <= j; t++) {
			if (isPalindrome(t)) {
				System.out.println(t);
			}
		}
	}

	private static boolean isPalindrome(int t) {
		int reverse = 0;
		for (int i = t; i > 0; i /= 10) {
			reverse = reverse * 10 + i % 10;
		}
		if (t == reverse) {
			return true;
		}
		return false;
	}
}
