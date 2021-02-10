package com.parvin.treesAndGraphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsAlgorithmMST {

	class Edge {
		int weight;
		boolean isIncluded = false; //is edge included in the MST
	}
	
	class Vertex {
		Map<Vertex, Edge> edges = new HashMap<>();
		boolean isVisited = false;
	}
	
	private List<Vertex> graph;
	
	private boolean isDisconnected() {
	    for (Vertex vertex : graph) {
	        if (!vertex.isVisited) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void run() {
		if(graph.size() > 0) {
			//start with any vertex
			graph.get(0).isVisited = true;
		}
		while(isDisconnected()) {
			
		}
	}
}
