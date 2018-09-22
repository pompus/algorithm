package com.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 9, 0, 7 , 1};
		insertionSort(arr);
		display(arr);
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
		}
	}

	/**
	 * keep left array as sorted and right array as unsorted at any single point of time
	 * for each elem, all elem having greater value in left side is moved right by one position 
	 * start with arr[1]
	 * 
	 * @param arr
	 */
	private static void insertionSort(int[] arr) {
		int n = arr.length;
		
		for (int i=1; i< n;i++) {
			int key = arr[i];
            int j = i-1;
            
            while (j >=0 && arr[j] > key) {
            	arr[j+1]=arr[j];
            	j--;
            }
            arr[j+1]=key;            
		}
	}
}

