package com.string;

public class StringToNumber {

	public static void main(String[] args) {
		String str = "103";
		int n = stringToNumber(str);
		System.out.println(n);
	}

	private static int stringToNumber(String str) {
		int num = 0;
		int pow=0;
		int n = str.length();
		for (int i = n - 1; i >= 0; i--) {
			char ch=str.charAt(i);
			//https://www.asciitable.com/
			//0's ascii value is 48
			int t= ch - '0';
			num+=(t*Math.pow(10, pow));
			pow++;
		}
		return num;
	}
}
