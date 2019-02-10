package org.yasar.globalhiring.tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class GNode {
	int nodeName;

	GNode parent = null;

	public GNode(int i, int value) {
		nodeName = i;
		this.value = value;
	}

	// direct neighbour edges list, without hopes
	List<GEdge> edges = new ArrayList<GEdge>();

	int value = Integer.MAX_VALUE;

	public String toString() {
		String values = "";
		edges.forEach(item -> values.concat(" -- " + item.toString()));
		return "origin; " + nodeName + "_W_" + value + "Edges: " + values;
	}
}

class GEdge {
	GNode dest;
	int weight;

	public String toString() {
		return "dest; " + dest + "_W_" + weight + "\n";
	}
}

public class FindPathValuesToRoot {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("org\\yasar\\globalhiring\\tree\\findPathValutesToRoot\\input1.txt");
		Scanner sc = new Scanner(file);
		// sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] str = sc.nextLine().split(" ");
		int nodesCount = Integer.parseInt(str[0]), q = Integer.parseInt(str[1]);

		// Nodes list
		List<GNode> nodes = new ArrayList<GNode>();

		// Node lookup Map
		Map<Integer, GNode> idToNode = new HashMap<Integer, GNode>();
		String[] values = sc.nextLine().split(" ");
		for (int j = 1; j <= nodesCount; j++) {
			GNode t = new GNode(j, Integer.parseInt(values[j - 1]));

			nodes.add(t);
			idToNode.put(t.nodeName, t);
		}

		for (int j = 1; j < nodesCount - 1; j++) {

			int s = sc.nextInt();
			int d = sc.nextInt();

			GNode src = idToNode.get(s);
			GNode dest = idToNode.get(d);

			GEdge edge = new GEdge();
			edge.dest = dest;
			src.edges.add(edge);

			edge = new GEdge();
			edge.dest = src;
			dest.edges.add(edge);

			if (dest.parent == null) {
				dest.parent = src;
			}
		}
		System.out.println(idToNode.toString());
	}

}
