package com.dynamic;

import java.util.Stack;

public class MinCostToReachDByTrain {
	static int INF = Integer.MAX_VALUE, N = 4;

	public static void main(String[] args) {
		int cost[][] = { { 0, 15, 80, 90 }, { INF, 0, 40, 50 }, { INF, INF, 0, 70 }, { INF, INF, INF, 0 } };
		System.out.println("The Minimum cost to reach station " + N + " is " + minCost(cost));

	}

	private static int minCost(int[][] cost) {
		// dist[i] stores minimum cost to reach station from station 0.
		int dist[] = new int[N];
		// path[j] stores the path to reach station N in minimum cost
		int path[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		dist[0] = 0;

		// Go through every station and check if using it as an intermediate
		// station gives better path
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (dist[j] > dist[i] + cost[i][j]) {
					dist[j] = dist[i] + cost[i][j];
					path[j] = i;
				}
			}
		}
		
		//back track the path from N-1 to 0 and put the result in stack to print it later 
		Stack<Integer> result=new Stack<>();
		result.push(N-1);
		for (int j=N-1; j>0;j=path[j]) {
			result.push(path[j]);
		}
		//print the result 
		System.out.println("Minimum cost path is:");
		while (!result.isEmpty()) {
			System.out.println(result.pop()+1);
		}
		
		return dist[N - 1];
	}
}
