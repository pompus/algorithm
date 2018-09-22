package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 * 
 * Depth First Traversal (or Search) for a graph is similar to Depth First
 * Traversal of a tree. The only catch here is, unlike trees, graphs may contain
 * cycles, so we may come to the same node again. To avoid processing a node
 * more than once, we use a boolean visited array. we should not do Dfs from a
 * specific source vertex as it traverses only the vertices reachable from that
 * given source vertex. All the vertices may not be reachable from a given
 * vertex (example Disconnected graph).
 * 
 */
public class DfsOfGraph {

	class Graph {
		private Integer vertex;
		private LinkedList<Integer> arr[];

		Graph(int vertex) {
			this.vertex = vertex;
			// LinkedList implements both List and Dequeue. And Dequeue have
			// several METHODS like: add/offer/push(stack)/offerFirst/OfferLast
			// remove/poll/peek/pollFirst/pollLast/peekFirst/peekLast/pop(stack)
			// In short, LinkedList supports all list , queue and stack methods
			this.arr = new LinkedList[vertex];
			for (int i = 0; i < vertex; i++) {
				arr[i] = new LinkedList<>();
			}
		}

		public void addEdge(int s, int d) {
			arr[s].add(d);
		}

		public void Dfs() {
			// keep track of vertex which are visited
			// default value of boolean is false
			boolean visited[] = new boolean[this.vertex];
			
			// this is important as it can be a disconnected graph as some vertex not connected to any other vertex
			for (int i=0; i<vertex; i++) {
				if (visited[i]==false ){
					dfsUtil(i, visited);
				}
			}
		}

		private void dfsUtil(int i, boolean[] visited) {
			visited[i]=true;
			System.out.println(i);
			
			Iterator<Integer> itr = arr[i].listIterator();
			while (itr.hasNext()) {
				Integer next = itr.next();
				if (visited[next] == false) {
					dfsUtil(next,visited);
				}
			}
		}
	}

	public static void main(String[] args) {
		// example of inner class
		Graph g = new DfsOfGraph().new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal ");
		g.Dfs();
	}
}
