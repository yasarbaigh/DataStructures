package org.yasar.ds.graph.bfs;

import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/bfsshortreach/problem



class VisitAllNodesNode implements Comparable<VisitAllNodesNode> {
    public int n;
    public int distance = -1;
    public TreeSet<VisitAllNodesNode> connections;
    public boolean visited = false;

    VisitAllNodesNode(int _n) {
        n = _n;
        connections = new TreeSet<VisitAllNodesNode>();
    }

    @Override public String toString(){
        return "n=" + n + " d=" + distance;
    }

    @Override public int compareTo(VisitAllNodesNode other) {
        return n - other.n;
    }

    public int bfs() {
        ArrayDeque<VisitAllNodesNode> Q = new ArrayDeque<VisitAllNodesNode>();
        visited = true;

        distance = 0;

        for (Iterator<VisitAllNodesNode> it = connections.iterator(); it.hasNext();) {
            VisitAllNodesNode neighbour = it.next();
            if (!neighbour.visited) {
                neighbour.distance = distance + 1;
                neighbour.visited = true;
                Q.add(neighbour);
            }
        }

        //System.out.println("Q=" + Q.toString());



        //its used to connect travel which requires multiple hopes
        
        while (Q.size() > 0) {
            VisitAllNodesNode found = Q.pop();

            for (Iterator<VisitAllNodesNode> it = found.connections.iterator(); it.hasNext();) {
                VisitAllNodesNode neighbour = it.next();
                if (!neighbour.visited) {
                    neighbour.distance = found.distance + 1;
                    neighbour.visited = true;
                    Q.add(neighbour);
                }
            }
        }



        //System.out.println("Q=" + Q.toString());
 

        return 0;
    }
}

public class VisitAllNodes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            int nodeCount = in.nextInt();
            int edgeCount = in.nextInt();


            VisitAllNodesNode[] nodes = new VisitAllNodesNode[nodeCount];

            for (int i = 0; i < nodeCount; i++) {
                nodes[i] = new VisitAllNodesNode(i);
            }

            for (int i = 0; i < edgeCount; i++) {
                int startNode = in.nextInt()-1;
                int endNode = in.nextInt()-1;

                nodes[startNode].connections.add(nodes[endNode]);
                nodes[endNode].connections.add(nodes[startNode]);
            }

            for (int i = 0; i < nodeCount; i++) {
                System.out.println(nodes[i].connections.toString());
            }

            int start = in.nextInt()-1;
            //System.out.println(start);

            //System.out.println(Arrays.toString(nodes));
            nodes[start].bfs();
            //System.out.println(Arrays.toString(nodes));

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < nodeCount; i++) {
                if (i != start) {
                    answer.append(nodes[i].distance > 0 ? nodes[i].distance * 6 : nodes[i].distance);
                    answer.append(" ");
                }
            }
            System.out.println(answer);



        }


    }


        //System.out.println(Arrays.toString(A));
        //System.out.println(Arrays.toString(B));


}
