package com.parvin.treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://www.hackerrank.com/challenges/kruskalmstrsub/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
	
public class KruskalMST {
	
	public static void main(String args[]) {
		List<Integer> from = Arrays.asList(1,1,1,1,2,3,4);
		List<Integer> to = Arrays.asList(2,3,4,5,3,4,5);
		List<Integer> weight = Arrays.asList(20,50,70,90,30,40,60);
		
		kruskalMST(5, from, to, weight);
	}
	
	public static void kruskalMST(int nodes, List<Integer> from, List<Integer> to, List<Integer> weight) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		KruskalMST mst = new KruskalMST();
		
		for(int i=0; i<from.size(); i++) {
			Edge e = mst.new Edge(from.get(i), to.get(i), weight.get(i));
			edges.add(e);
		}
		
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return Integer.compare(e1.weight, e2.weight);
			}
		});
		
		System.out.println(createMST(edges, nodes));
	}

	private static int createMST(ArrayList<Edge> edges, int nodes) {
		boolean[] visited = new boolean[nodes+1];
		int weight = 0;
		for(int i = 0; i < edges.size(); i++) { 
			Edge edge = edges.get(i);
			if(!visited[edge.source] || !visited[edge.dest]){
				visited[edge.source] = true;
				visited[edge.dest] = true;
				weight = weight + edge.weight;
			}
		} 
		return weight;
	}

	class Edge {
		int source;
		int dest;
		int weight;
		
		private Edge(int src, int dest, int weight) {
			this.source = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
}
