package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 *
 * Breadth First Traversal (or Search) for a graph is similar to Breadth First
 * Traversal of a tree (See method 2 of this post). The only catch here is,
 * unlike trees, graphs may contain cycles, so we may come to the same node
 * again. To avoid processing a node more than once, we use a boolean visited
 * array. For simplicity, it is assumed that all vertices are reachable from the
 * starting vertex.
 */
public class BfsOfGraph {

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

		public void BFS(int i) {
			// keep track of vertex which are visited
			// default value of boolean is false
			boolean visited[] = new boolean[this.vertex];

			// create a queue to add / remove the vertex
			LinkedList<Integer> queue = new LinkedList<>();

			queue.add(i);
			visited[i] = true;

			while (queue.size() != 0) {
				i = queue.poll();
				System.out.println(i);

				Iterator<Integer> itr = arr[i].listIterator();
				while (itr.hasNext()) {
					Integer next = itr.next();
					if (visited[next] == false) {
						queue.add(next);
						visited[next] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// example of inner class
		Graph g = new BfsOfGraph().new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		// start BFS from node 2, you can start BFS from any node
		g.BFS(2);
	}
}
