package com.dynamic;

public class PartitionProblem {

	public static void main(String[] args) {
		 int arr[] = {3, 1, 1, 2, 2,1};
	        int n = arr.length;
	        if (findPartition(arr, n) == true)
	            System.out.println("Can be divided into two subsets of equal sum");
	        else
	            System.out.println("Can not be divided into two subsets of equal sum");
	}

	private static boolean findPartition(int[] arr, int n) {
		int sum = 0;
        int i, j;
 
        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];
 
        if (sum%2 != 0)
            return false;
        
        
		return false;
	}

}
