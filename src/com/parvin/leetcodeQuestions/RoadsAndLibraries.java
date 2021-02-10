package com.parvin.leetcodeQuestions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.hackerrank.com/challenges/torque-and-development/problem

public class RoadsAndLibraries {
	private static LinkedList<Integer>[] possibleConnections;

    // Complete the roadsAndLibraries function below.
    private static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    	possibleConnections = new LinkedList[n+1];
    	
    	//Init empty list
    	for(int i=1; i<=n; i++) {
    		possibleConnections[i] = new LinkedList<Integer>();
    	}
    	
    	//add the edges
    	for(int i=0; i<cities.length; i++) {
    		addEdge(cities[i][0], cities[i][1]);
    	}
    	
    	List<Integer> cityGroups = connectedCities(n);
    	
    	long totalCost = 0;
    	
    	for(int cg : cityGroups) {
    		if(c_road < c_lib) {
    			totalCost = totalCost + (c_road * (cg-1)) + c_lib;
    		}else {
    			totalCost = totalCost + (c_lib * cg);
    		}
    	}
    	
    	return totalCost;

    }
    
    private static void addEdge(int src, int dest) {
    	possibleConnections[src].add(dest);
    	possibleConnections[dest].add(src);
    }
    
    private static List<Integer> connectedCities(int numOfCities) {
    	boolean[] visited = new boolean[numOfCities+1]; 
		List<Integer> connections = new ArrayList<Integer>();
		
		for(int v = 1; v <= numOfCities; ++v) { 
			if(!visited[v]) { 
				// print all reachable vertices 
				// from v 
				int c = 1;
				c = findConnections(v,visited, c); 
				connections.add(c);
			}
		} 
		return connections;
    }

    private static int findConnections(int origin, boolean[] visited, int countOfConnectedCities) {
    	visited[origin] = true;
    	for(int city: possibleConnections[origin]) {
    		if(!visited[city]) {
    			countOfConnectedCities = 1 + findConnections(city, visited,countOfConnectedCities);
    		}
    	}
    	return countOfConnectedCities;
    }
    
    public static void main(String[] args) throws IOException {
    	int numOfCities = 6;
    	int c_lib = 2;
    	int c_road = 5;
    	int[][] cities = {{1,3},{3,4},{2,4},{1,2},{2,3},{5,6}};
    	long result = roadsAndLibraries(numOfCities, c_lib, c_road, cities);
    	System.out.println(result);
    }
}
