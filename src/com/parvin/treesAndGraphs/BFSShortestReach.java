package com.parvin.treesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

public class BFSShortestReach {

	public static int[] shortestReach(int[][] edges, int nodes, int start, int numOfEdges) {
		LinkedList<Integer>[] vertices = new LinkedList[nodes+1];
		
		for(int i=1; i<=nodes; i++) {
			vertices[i] = new LinkedList<Integer>();
		}
		
		createAdjacencyList(edges, numOfEdges, vertices);
		int[] cost = getShortestReach(vertices, start, nodes);
		return Arrays.stream(cost).filter(c -> c != 0).toArray(); 
	}
	
	private static void createAdjacencyList(int[][] edges, int numOfEdges, LinkedList<Integer>[] vertices) {
		for(int i=0; i<numOfEdges; i++) {
			vertices[edges[i][0]].add(edges[i][1]);
			vertices[edges[i][1]].add(edges[i][0]);
		}
	}

	private static int[] getShortestReach(LinkedList<Integer>[] vertices, int start, int nodes) {
		boolean[] visited = new boolean[nodes+1];
		int[] cost = new int[nodes+1];
		
		if(!visited[start]) {
			dfsUtil(start, visited, vertices, cost);
		}
		
		for(int i=1; i<=nodes; i++) {
			if(!visited[i]) {
				dfsUtil(i, visited, vertices, cost);
			}
		}
		return cost;
	}
	
	private static void dfsUtil(int start, boolean[] visited, LinkedList<Integer>[] vertices, int[] cost) {
		visited[start] = true;
		if(vertices[start].isEmpty()) {
			cost[start] = -1;
		}
		for(int x: vertices[start]) {
			if(!visited[x]) {
				cost[x] = cost[start]+6;//have to put in array the cost
				dfsUtil(x, visited, vertices, cost);
			}
		}
	}
}
