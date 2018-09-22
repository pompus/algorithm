package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/check-given-graph-tree/
 * 
 * An undirected graph is tree if it has following properties.
 * 
 * 1) There is no cycle.
 * 
 * For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is
 * already visited and u is not parent of v, then there is a cycle in graph
 * 
 * 2) The graph is connected.
 * 
 * Since the graph is undirected, we can start BFS or DFS from any vertex and
 * check if all vertices are reachable or not. If all vertices are reachable,
 * then graph is connected, otherwise not.
 *
 */
public class CheckIfAGraphIsTree {

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

		/**
		 * undirected graph will by default should have edges in both direction
		 * 
		 * @param s
		 * @param d
		 */
		public void addEdge(int s, int d) {
			arr[s].add(d);
			arr[d].add(s);
		}

		public boolean isTree() {
			boolean visited[] = new boolean[this.vertex];
			// start DFS with any node, say=0 where parent is -1 which means it
			// has no parent
			if (isCyclicUtil(0, visited, -1)) {
				return false;
			}

			for (int v = 0; v < visited.length; v++) {
				if (!visited[v]) {
					return false;
				}
			}
			return true;
		}

		/**
		 * @return true when there is cycle
		 */
		private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
			visited[v] = true;

			Iterator<Integer> itr = arr[v].listIterator();
			while (itr.hasNext()) {
				Integer child = itr.next();
				// If an adjacent is visited and not parent of current vertex,
				// then there is a cycle
				if (visited[child] && parent != child) {
					return true;
				} // If an adjacent is not visited, then recur for that adjacent
				else if (!visited[child] && isCyclicUtil(child, visited, v)) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Graph g1 = new CheckIfAGraphIsTree().new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		System.out.println("This Graph is Tree? " + g1.isTree());

		Graph g2 = new CheckIfAGraphIsTree().new Graph(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);

		System.out.println("This Graph is Tree? " + g2.isTree());
	}
}
