package com.parvin.leetcodeQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PrimsAlgorithm {
	
	class Edge {

		int src;
		int dest;
		int weight;
		
		Edge(int s, int d, int w){
			src = s;
			dest = d;
			weight = w;
		}
	}
	
	public static void main(String args[]) {
		int[][] graph = { { 0, 2, 0, 6, 0 }, 
			                { 2, 0, 3, 8, 5 }, 
			                { 0, 3, 0, 0, 7 }, 
			                { 6, 8, 0, 0, 9 }, 
			                { 0, 5, 7, 9, 0 } }; 
		
		costEffectiveGraph(graph, 5);
	}
	
	private static void costEffectiveGraph(int[][] input, int n) {
		PrimsAlgorithm ps = new PrimsAlgorithm();
		LinkedList<Edge> edges = createWeightedEdges(input, n, ps);
		
		Collections.sort(edges, new Comparator<Edge>() {
									@Override
									public int compare(Edge o1, Edge o2) {
										return o1.weight-o2.weight;
									}});
		//createTreeWithMinimumCost(edges, input);
		int cost = 0;
		for(Edge e: edges) {
			cost = cost + e.weight;
		}
		System.out.println(cost);
	}

//	private static int createTreeWithMinimumCost(LinkedList<Edge> edges, int[][] input) {
//		boolean[] visited = new boolean[input.length];
//		int cost = 0;
//		for(Edge e: edges) {
//			int v = e.src;
//			if(!visited[v]) {
//				cost = cost + dfsUtil(v, e, input, visited);
//			}
//			//cost = cost + e.weight;
//		}
//	}
	
//	private static int dfsUtil(int source, Edge edge, int[][] input, boolean[] visited) {
//		visited[source] = true;
//		int d = edge.dest;
//		if(!visited[d]) {
//			return edge.weight;
//		}else if() {
//			
//		}
//	}

	private static LinkedList<Edge> createWeightedEdges(int[][] input, int n, PrimsAlgorithm ps) {
		LinkedList<Edge> edges = new LinkedList<Edge>();
		
		
		for(int i=0; i<n; i++) {
			int src = i;
			for(int j=0; j<n; j++) {
				if(input[i][j]==0 || input[i][j]==-1) {
					continue;
				}else {
					int dest = j;
					int weight = input[i][j];
					Edge e1 = ps. new Edge(src, dest, weight);
					Edge e2 = ps. new Edge(dest, src, weight);
					if(!edges.contains(e1) && !edges.contains(e2)){
						// not adding duplicate edges
						edges.add(e1);
					}
				}
			}
			
		}
		return edges;
	}
}
