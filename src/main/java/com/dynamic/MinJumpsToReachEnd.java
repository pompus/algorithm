package com.dynamic;

/**
 * https://www.youtube.com/watch?v=cETfFsSTGJI
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * Given an array of integers where each element represents the max number of
 * steps that can be made forward from that element. Write a function to return
 * the minimum number of jumps to reach the end of the array (starting from the
 * first element). If an element is 0, then cannot move through that element.
 * 
 * Example:
 * 
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} Output: 3 (1-> 3 -> 8 ->9)
 *
 */
public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };
		System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr, arr.length));
		int arr1[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr1, arr1.length));
	}

	private static int minJumps(int[] arr, int length) {
		if (arr[0] == 0 || length == 0) {
			return Integer.MAX_VALUE;
		}
		// used to calculate number of jumps
		int jumps[] = new int[length];
		// store the nodes to calculate min number of jumps
		int ways[] = new int[length];
		
		jumps[0] = 0;
		ways[0]=-1;
		
		for (int i = 1; i < length; i++) {

			jumps[i] = Integer.MAX_VALUE;

			for (int j = 0; j < i; j++) {
				if (i <= arr[j] + j && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					
					if (jumps[i]==jumps[j] + 1) {
						ways[i]=j;
					}
				}
			}
		}
		
		// print the ways to get minimum number of jumps
		int current=-1;
		for (int i=1; i< ways.length;i++) {
			if (current!=ways[i]) {
				current=ways[i];
				System.out.print(arr[ways[i]]+ "->");
			}			
		}
		System.out.print(arr[length-1]);
		System.out.println();
		
		return jumps[length - 1];
	}
}
