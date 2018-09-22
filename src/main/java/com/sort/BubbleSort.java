package com.sort;

/**
 * Keep the greatest element in the rightmost place 
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 9, 0, 7 };
		bubbleSort(arr);
		display(arr);
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
		}
	}

	/**
	 * keep max element at last in each iteration
	 * 
	 * @param arr
	 */
	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean mod=false;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					mod=true;
				}
			}
			if (!mod)
				break;
		}
	}
}
