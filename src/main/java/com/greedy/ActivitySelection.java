package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author HP PC
 * 
 *         You are given n activities with their start and finish times. Select
 *         the maximum number of activities that can be performed by a single
 *         person, assuming that a person can only work on a single activity at
 *         a time.
 *
 */
public class ActivitySelection {

	public static void main(String[] args) {
		// parameters are provided in (start,finish) form
		// given activities are NOT sorted for 2nd = finish parameter
		int activity[][] = { { 5, 9 }, { 1, 2 }, { 3, 4 }, { 0, 6 }, { 5, 7 }, { 8, 9 } };
		printActivities(activity);
	}

	private static void printActivities(int[][] activity) {
		sort(activity, 1);
		System.out.println("after sorting by finish time:");
		for (int i=0; i<activity.length;i++){
				System.out.println(activity[i][0]+","+activity[i][1]);
			}
		System.out.println("after sorting print tasks");

		int i=0,j=0;
		//track for last selected activity
		int k=0,l=1;
		
		// the 1st task will be taken by default
		System.out.println(activity[i][j]+","+activity[i][j+1]);
		for (i=1; i< activity.length;i++) {
			if (activity[i][j] >= activity[k][l]) {
				System.out.println(activity[i][j]+","+activity[i][j+1]);
				k=i;
			}
		}
	}

	/**
	 * sort using Comparator
	 * 
	 * @param activity
	 * @param colnum
	 */
	private static void sort(int[][] activity, int colnum) {
		Arrays.sort(activity, new Comparator<int[]>() {	           
	          @Override             
	          // Compare values according to columns
	          public int compare(final int[] entry1, 
	                             final int[] entry2) {
	            if (entry1[colnum] > entry2[colnum])
	                return 1;
	            else
	                return -1;
	          }
	        }); 		
	}
}
