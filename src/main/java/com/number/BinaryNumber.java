package com.number;

/**
 * The binary numeral system, or base-2 number system, represents numeric values
 * using two symbols: 0 and 1. More specifically, the usual base-2 system is a
 * positional notation with a radix of 2. 
 *
 */
public class BinaryNumber {

	public static void main(String[] args) {
		printBinary(10001);
		printBinary(10301);
	}

	private static void printBinary(int binary) {
		if (binary==0) {
			System.out.println(binary + " is binary number");
			return;
		}
		int original=binary;
		
		while (binary >0) {
			if (binary % 10 > 1) {
				System.out.println(original + " is not binary number");
				break;
			}
			binary/=10;
		}
		if (binary==0)
		System.out.println(original + " is binary number");
	}
}
