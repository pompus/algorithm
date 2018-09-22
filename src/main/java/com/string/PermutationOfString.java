package com.string;

public class PermutationOfString {

	public static void main(String[] args) {
		String input = "DEF";
		printAllStrings(input);
	}

	private static void printAllStrings(String input) {
		permute(input, 0, input.length() - 1);
	}

	private static void permute(String input, int l, int r) {
		if (l == r) {
			System.out.println(input);
		} else {
			for (int i = l; i <= r; i++) {
				input = swap(input, l, i);
				permute(input, l + 1, r);
				// backtrack to go the original number so that we can work with
				// the next iteration with correct number
				input = swap(input, l, i);
			}
		}
	}

	private static String swap(String input, int l, int r) {
		char t;
		char[] temp = input.toCharArray();
		t = temp[r];
		temp[r] = temp[l];
		temp[l] = t;
		return String.valueOf(temp);
	}
}
