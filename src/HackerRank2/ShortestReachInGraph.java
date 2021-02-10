package HackerRank2;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Utilities.PrintArrays;


//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
// need to implement using Queue as in BFS, I implemented it wrong using DFS

public class ShortestReachInGraph {

	public static void main(String args[]) {
		int numOfNodes = 6;
		int numEdges = 4;
		int[][] connections = {{2,1}, {3,2}, {3,4}, {1,5}};
		int start = 3;
		int[] result = shortestReach(numOfNodes, numEdges, connections, start);
		PrintArrays.printArray(result);
		
	}

	
	private static int[] shortestReach(int nodes, int numEdges, int[][] connections, int start) {
		LinkedList<Integer>[] adjacencyList = new LinkedList[nodes+1];
		
		for(int i=1; i<=nodes; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<connections.length; i++) {
			adjacencyList[connections[i][0]].add(connections[i][1]);
			//adjacencyList[connections[i][1]].add(connections[i][0]);
		}
		
		int[] result = findShortestReach(nodes, adjacencyList, connections, start);
		
		return Arrays.stream(result).filter(c -> c != 0).toArray();
	}


	private static int[] findShortestReach(int nodes, LinkedList<Integer>[] adjacencyList, int[][] connections, int start) {
		boolean[] visited = new boolean[nodes+1];
		int[] costArr = new int[nodes+1];
		
		for(int i=1; i<=nodes; i++) {
			if(adjacencyList[i].isEmpty()) {
				costArr[i] = -1;
			}
		}
		
		Queue<Integer> qu = new ArrayDeque<Integer>();
		qu.add(start);
		
		while(!qu.isEmpty()) {
			int top = qu.poll();
			
			for(int e : adjacencyList[top]) {
				if(!visited[e]) {
					costArr[e] = costArr[top] + 6;
					visited[e] = true;
					qu.add(e);
				}
			}
		}
		return costArr;
	}

}
