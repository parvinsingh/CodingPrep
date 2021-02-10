package com.parvin.leetcodeQuestions;

import java.util.LinkedList;
import java.util.LinkedList; 

//similar to https://leetcode.com/problems/friend-circles/ 
//and https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

public class Graph { 
	// A user define class to represent a graph. 
	// A graph is an array of adjacency lists. 
	// Size of array will be V (number of vertices 
	// in graph) 
	int V; 
	LinkedList<Integer>[] adjListArray; 
	
	// constructor 
	Graph(int V) { 
		this.V = V; 
		adjListArray = new LinkedList[V]; 
		for(int i = 0; i < V ; i++){ 
			adjListArray[i] = new LinkedList<Integer>(); 
		} 
	} 
	
	// Adds an edge to an undirected graph 
	void addEdge( int src, int dest) { 
		adjListArray[src].add(dest); 
		adjListArray[dest].add(src); 
	} 
	
	void DFSUtil(int v, boolean[] visited, LinkedList<Integer> components) { 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		components.add(v);
		System.out.print(v+" "); 
		// Recur for all the vertices 
		// adjacent to this vertex 
		for (int x : adjListArray[v]) { 
			if(!visited[x]) {
				DFSUtil(x,visited, components); 
			}else if(v != x) {
				//there is a cycle in the graph
				System.out.println("there is a cycle in graph");
			}
		} 

	} 
	void connectedComponents() { 
		// Mark all the vertices as not visited 
		int count=0;
		boolean[] visited = new boolean[V]; 
		LinkedList<Integer>[] list = new LinkedList[V];
		for(int v = 0; v < V; ++v) { 
			if(!visited[v]) { 
				list[v] = new LinkedList<Integer>();
				DFSUtil(v,visited, list[v]); 
				System.out.println(); 
				count++;
			} 
			
		} 
		System.out.println("Count = " + count);
	} 
	
	
	// Driver program to test above 
	public static void main(String[] args){ 
		// Create a graph given in the above diagram 
		Graph g = new Graph(5); // 5 vertices numbered from 0 to 4 
		
		g.addEdge(1, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 4);
		System.out.println("Following are connected components"); 
		g.connectedComponents(); 
	} 
}	 
