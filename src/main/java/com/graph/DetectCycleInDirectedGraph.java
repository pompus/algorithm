package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * 
 * There is a cycle in a graph only if there is a back edge present in the
 * graph. A back edge is an edge that is from a node to itself (self-loop) or
 * one of its ancestor in the tree produced by DFS
 *
 */
public class DetectCycleInDirectedGraph {

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

		public boolean isCyClic() {
			// keep track of vertex which are visited
			// default value of boolean is false
			boolean visited[] = new boolean[vertex];
			boolean[] recStack = new boolean[vertex];

			// this is important as it can be a disconnected graph as some
			// vertex not connected to any other vertex
			for (int i = 0; i < vertex; i++) {
				if (!visited[i] && cyclicUtil(i, visited, recStack)) {
					return true;
				}
			}
			return false;
		}

		private boolean cyclicUtil(int i, boolean[] visited, boolean[] recStack) {
			if (recStack[i]) {
				return true;
			}

			visited[i] = true;
			recStack[i] = true;

			Iterator<Integer> itr = arr[i].listIterator();
			while (itr.hasNext()) {
				Integer next = itr.next();
				return cyclicUtil(next, visited, recStack);
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// example of inner class
		Graph g = new DetectCycleInDirectedGraph().new Graph(5);

		// disconnected graph
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 4);

		System.out.println("This disconnected Graph has cycle? " + g.isCyClic());

		g = new DetectCycleInDirectedGraph().new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);

		System.out.println("This Graph has cycle? " + g.isCyClic());

		g = new DetectCycleInDirectedGraph().new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("This Graph has cycle? " + g.isCyClic());
	}
}
