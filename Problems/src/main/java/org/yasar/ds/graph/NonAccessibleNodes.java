package org.yasar.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

// https://www.youtube.com/watch?v=iuuIk5pec6o

public class NonAccessibleNodes {

	Map<Integer, List<Integer>> nds = new HashMap<>();

	public static void main(String[] args) {
		NonAccessibleNodes o1 = new NonAccessibleNodes();

		System.out.println(o1.countUnVistedPairs(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }));

		System.out.println(o1.countUnVistedPairs(7, new int[][] { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } }));

	}

	public long countPairs(int n, int[][] edges) {

		return countUnVistedPairs(n, edges);
	}

	public long countUnVistedPairs(int nodeLength, int[][] edges) {

		prepareGraph(nodeLength, edges);

		boolean[] visited = new boolean[nodeLength];
		long unVisitedPairCount = 0;

		int nodesYetToVisit = nodeLength;
		for (int i = 0; i < nodeLength; i++) {
			if (visited[i] == false) {
				// current-visited
				int currenVistied = performBFSMarkVisited(i, visited);
				int unableVisitByI = nodesYetToVisit - currenVistied;
				unVisitedPairCount += (currenVistied * unableVisitByI);

				nodesYetToVisit -= currenVistied;
			}

		}

		return unVisitedPairCount;
	}

	private int performBFSMarkVisited(int i, boolean[] visited) {

		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);

		while (!q.isEmpty()) {
			int t = q.poll();
			if (visited[t] == true)
				continue;

			visited[t] = true;
			cnt++;

			List<Integer> adjnct = nds.get(t);

			for (Integer e : adjnct) {
				if (visited[e] == false) {
					q.add(e);
				}
			}
		}

		return cnt;

	}

	public String prepareGraph(int n, int[][] edges) {

		nds.clear();

		for (int i = 0; i < n; i++) {
			// initializing with all nodes
			nds.put(i, new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {

			List<Integer> v1 = nds.get(edges[i][0]);
			if (v1 == null) {
				v1 = new ArrayList<>();
				nds.put(edges[i][0], v1);
			}
			v1.add(edges[i][1]);

			List<Integer> v2 = nds.get(edges[i][1]);
			if (v2 == null) {
				v2 = new ArrayList<>();
				nds.put(edges[i][1], v2);
			}
			v2.add(edges[i][0]);
		}

		return "";

	}

	public long roamGraphToFindUnVisitableNodes(int n) {
		boolean[] visited = new boolean[n];

		nds.forEach((k, v) -> {
			if (visited[k] == false) {
				visited[k] = true;

				for (int x : v)
					visited[x] = true;
			}

		});

		long cnt = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false)
				cnt++;
		}

		return cnt;
	}
}