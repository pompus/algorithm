package com.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 9, 0, 7 , 1};
		selectionSort(arr);
		display(arr);
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
		}
	}

	/**
	 * keep min element to the start always
	 * 
	 * @param arr
	 */
	private static void selectionSort(int[] arr) {
		int n = arr.length;
		int min_element=0;
		
		for (int i = 0; i < n - 1; i++) {
			int j=min_element;
			
			while (j <n) {
				if (arr[j] < arr[min_element]) {
					int temp = arr[j];
					arr[j] = arr[min_element];
					arr[min_element] = temp;
				}
				j++;
			}
			min_element++;
		}
	}
}
