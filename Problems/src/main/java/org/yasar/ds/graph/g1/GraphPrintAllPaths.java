package org.yasar.ds.graph.g1;

import java.util.LinkedList;
/*

 https://algorithms.tutorialhorizon.com/graph-print-all-paths-between-source-and-destination/
 
 
 
 * 
 */

public class GraphPrintAllPaths {

	public void print(Graph graph, int start, int end, String path, boolean[] visited) {
		final String newPath = path + "->" + start;
		visited[start] = true;
		final LinkedList<Node> list = graph.adjacencyList[start];
		for (int i = 0; i < list.size(); i++) {
			final Node node = list.get(i);
			if (node.destination != end && visited[node.destination] == false) {
				// visited[node.destination] = true;
				print(graph, node.destination, end, newPath, visited);
			} else if (node.destination == end) {
				System.out.println(newPath + "->" + node.destination);
			}
		}
		// remove from path
		visited[start] = false;
	}

	public void printAllPaths(Graph graph, int start, int end) {
		final boolean[] visited = new boolean[graph.vertices];
		visited[start] = true;
		print(graph, start, end, "", visited);
		System.out.println("GraphPrintAllPaths.printAllPaths()");
	}

	public static void main(String[] args) {
		/*
		 * final int vertices = 6; final Graph graph = new Graph(vertices);
		 * graph.addEdge(0, 1); graph.addEdge(0, 2); graph.addEdge(1, 2);
		 * graph.addEdge(1, 3); graph.addEdge(3, 4); graph.addEdge(2, 3);
		 * graph.addEdge(4, 0); graph.addEdge(4, 1); graph.addEdge(4, 5); final
		 * GraphPrintAllPaths p = new GraphPrintAllPaths();
		 * p.printAllPaths(graph,0,0);
		 */

		// loop in graph
		final int vertices = 5;
		final Graph graph = new Graph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);

		graph.addEdge(2, 0);

		final GraphPrintAllPaths p = new GraphPrintAllPaths();
		p.printAllPaths(graph, 0, 0);
		System.out.println("GraphPrintAllPaths.main()");

	}
}

class Graph {
	int vertices;
	LinkedList<Node>[] adjacencyList;

	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList<Node>();
		}
	}

	public void addEdge(int source, int destination) {
		final Node node = new Node(source, destination);
		// add edge
		adjacencyList[source].addLast(node);
	}
}

class Node {
	int source;
	int destination;

	public Node(int source, int destination) {
		this.source = source;
		this.destination = destination;
	}

}
