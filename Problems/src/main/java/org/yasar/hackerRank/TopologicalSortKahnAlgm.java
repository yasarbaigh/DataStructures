package org.yasar.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//class SelfTopology<T> {
//	
//	
//	List<ArrayList<T>> nodeVertices = new ArrayList<>();
//	public SelfTopology(intn ) {
//		
//		for(ArrayList<T> a : nodeVertices) {
//			a.add(new ArrayList<>())
//		}
//	}
//}

public class TopologicalSortKahnAlgm {

	public static List<String> process(String[][] sbjts) {
		
		// add node , to all Edges
		Map<String, List<String>> nodeVertices = new HashMap<>();
		
		// Node and dependant parents-count, if node is zero, then its root-node
		Map<String, Integer> path = new HashMap<>();

		
		

		for (int i = 0; i < sbjts.length; i++) {

			var v = nodeVertices.get(sbjts[i][0]);

			if (v == null) {
				v = new ArrayList<String>();
				nodeVertices.put(sbjts[i][0], v);
			}

			path.putIfAbsent(sbjts[i][0], 0);

			var k = path.get(sbjts[i][1]);
			if (k == null) {
				path.put(sbjts[i][1], 1);
			} else {
				path.put(sbjts[i][1], k + 1);
			}

			v.add(sbjts[i][1]);

		}

		// adding those parent-node, which has no dependency
		Queue<String> q = new LinkedList<>();
		path.forEach((k, v) -> {
			if (v.intValue() == 0) {
				q.add(k);
			}
		});

		List<String> topoSort = new ArrayList<>();
		while (!q.isEmpty()) {

			String t = q.poll();
			topoSort.add(t);

			for (String s : nodeVertices.getOrDefault(t, Collections.emptyList())) {
				var v = path.get(s);

				if (v == null) {
					q.add(s);
				}else if (v  <= 1) {
					path.remove(s);
					q.add(s);
				} else {
					
					// for child, one dependecny is reduced.
					path.put(s, v - 1);
				}

			}
		}

		return topoSort;

	}

	public static void main(String[] args) {
		String[][] s1 = { { "Probability", "Data Structures" }, { "Intro to Java", "Calculus" },
				{ "English II", "Algebra" }, { "Data Structures", "Algorithms" }, { "Algebra", "Intro to Java" },
				{ "English", "English II" }, { "Algorithms", "Graphs" }, { "Calculus", "Probability" }, };

		// [English, English II, Algebra, Intro to Java, Calculus, Probability, Data
		// Structures, Algorithms, Graphs]
		String[][] s2 = { { "1", "2" }, { "2", "3" }, { "3", "4" }, { "4", "5" }, { "5", "6" }, { "6", "7" },
				{ "7", "8" } };

		String[][] s3 = { { "5", "2" }, { "5", "0" }, { "4", "0" }, { "4", "1" }, { "2", "3" }, { "3", "1" } };
		
		String[][] s5 = {{ "4", "5" } , { "3", "5" }, { "1", "5" }, { "2", "5" } , { "5", "6" }, { "6", "7" },
				{ "7", "8" } , { "8", "5" } ,};
		System.out.println(process(s3));
	}

}
