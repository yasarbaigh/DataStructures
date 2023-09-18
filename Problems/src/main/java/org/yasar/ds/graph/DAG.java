package org.yasar.ds.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class DAG_Graph_Vertex_Node {
	int start, end, weight;

	public DAG_Graph_Vertex_Node(int start, int end, int weight) {
		this.start = start;
		this.end = end;

		this.weight = weight;

	}
}

class DAG_Graph {

	Map<Integer, List<DAG_Graph_Vertex_Node>> graphNodes = new LinkedHashMap<>();

	public void addAdjacentVertex(int src, int end, int weight) {
		DAG_Graph_Vertex_Node node = new DAG_Graph_Vertex_Node(src, end, weight);

		List<DAG_Graph_Vertex_Node> directedNodes = graphNodes.get(src);

		if (directedNodes == null) {
			directedNodes = new ArrayList<>();
			graphNodes.put(src, directedNodes);
		}

		directedNodes.add(node);

	}

	public void pirntEdgesForAllNodes() {

		for (Map.Entry<Integer, List<DAG_Graph_Vertex_Node>> entry : graphNodes.entrySet()) {

			System.out.print(" From " + entry.getKey() + "\t");
			for (DAG_Graph_Vertex_Node nd : entry.getValue()) {

				System.out.print("( " + nd.end + " ,  " + nd.weight + "), ");
			}
			System.out.println();

		}

	}

}

public class DAG {

	public static void main(String[] args) {
		DAG_Graph graph = new DAG_Graph();
		graph.addAdjacentVertex(0, 2, 3);
		graph.addAdjacentVertex(0, 1, 5);
		graph.addAdjacentVertex(1, 2, 2);
		graph.addAdjacentVertex(1, 3, 6);
		graph.addAdjacentVertex(2, 3, 7);

		graph.addAdjacentVertex(2, 4, 4);
		graph.addAdjacentVertex(2, 5, 2);
		graph.addAdjacentVertex(3, 4, -1);
		graph.addAdjacentVertex(4, 5, -2);

		graph.pirntEdgesForAllNodes();
	}

}
