package com.dynamic;

/**
 * https://www.youtube.com/watch?v=oNI0rf2P9gE
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 * 
 *Input:
       graph[][] = { {0,   5,  INF, 10},
                    {INF,  0,  3,  INF},
                    {INF, INF, 0,   1},
                    {INF, INF, INF, 0} }
which represents the following graph
             10
       (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
       \|/         |
       (1)------->(2)
            3       
Note that the value of graph[i][j] is 0 if i is equal to j 
And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.

Output:
Shortest distance matrix
      0      5      8      9
    INF      0      3      4
    INF    INF      0      1
    INF    INF    INF      0 
 */
public class AllPairShortestPathFloidWarshall {
	final static int INF = Integer.MAX_VALUE, V = 4;

	public static void main(String[] args) {
		int graph[][] = 
			{ 
				{ 0, 3, INF, 7 }, 
				{ 8, 0, 2, INF }, 
				{ 5, INF, 0, 1 }, 
				{ 2, INF, INF, 0 } 
			};
		// { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
		// Print the solution
		floydWarshall(graph);
	}

	private static void floydWarshall(int[][] graph) {

		int dist[][] = new int[V][V];

		// fill array with original graph value
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		// we need to find shortest path by considering each vertex as
		// intermediate - so, for each intermediate vertices, run below
		for (int k = 0; k < V; k++) {
			// take each vertex as source
			for (int i = 0; i < V; i++) {
				// for each source vertex, check all vertex as destination
				for (int j = 0; j < V; j++) {
					if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		// print shortest paths
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(dist[i][j]);
				if (j != V - 1) {
					System.out.print(" , ");
				}
			}
			System.out.println();
		}
	}
}
