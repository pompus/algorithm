package com.string;

public class MoveZerosToEndInAnArray {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int n = arr.length;
		pushZerosToEnd(arr);
		System.out.println("Array after pushing zeros to the end: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void pushZerosToEnd(int[] arr) {
		int count = 0;
		// Traverse the array. If element encountered is non-zero, then replace
		// the element at index 'count' with this element
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		// Make all elements 0 from count to end.
		while (count < arr.length) {
			arr[count++] = 0;
		}
	}
}
