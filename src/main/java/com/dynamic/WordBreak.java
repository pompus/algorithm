package com.dynamic;

import java.util.Arrays;

/**
 * Given an input string and a dictionary of words, find out if the input string
 * can be segmented into a space-separated sequence of dictionary words. See
 * following examples for more details. This is a famous Google interview
 * question, also being asked by many other companies now a days.
 * 
 * Consider the following dictionary { i, like, sam, sung, samsung, mobile, ice,
 * cream, icecream, man, go, mango}
 * 
 * Input: ilike Output: Yes The string can be segmented as "i like".
 * 
 * Input: ilikesamsung Output: Yes The string can be segmented as "i like
 * samsung" or "i like sam sung".
 *
 */
public class WordBreak {

	static String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
			"like", "ice", "cream" };

	public static void main(String[] args) {
		System.out.println(wordBreak("ilikeicecream"));
		System.out.println(wordBreak("idontlikeicecream"));
	}

	private static boolean wordBreak(String s) {
		int[] pos = new int[s.length() + 1];

		Arrays.fill(pos, -1);

		pos[0] = 0;

		for (int i = 0; i < s.length(); i++) {
			if (pos[i] != -1) {
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);

					for (int k = 0; k < dictionary.length; k++) {
						if (dictionary[k].equals(sub)) {
							pos[j] = i;
							break;
						}
					}
				}
			}
		}

		return pos[s.length()] != -1;
	}

}
