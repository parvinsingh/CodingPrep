package HackerRank2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.hackerrank.com/challenges/torque-and-development/problem

public class RoadsAndLibraries2 {

	private static LinkedList<Integer>[] possibleConnections;

    // Complete the roadsAndLibraries function below.
    private static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    	possibleConnections = new LinkedList[n+1];
    	
    	//initialize empty list
    	for(int i=1; i<=n; i++) {
    		possibleConnections[i] = new LinkedList<Integer>();
    	}
    	
    	//add the edges
    	for(int i=0; i<cities.length; i++) {
    		addEdge(cities[i][0], cities[i][1]);
    	}
    	
    	List<Integer> connections = findConnections(cities, n);
    	int total = 0;
    	for(int groupSize: connections) {
    		if(c_road < c_lib) {
    			total = total + (c_road*(groupSize-1)) + c_lib;
    		}else {
    			total = total + (c_lib*groupSize);
    		}
    	}
    	
    	return total;
    }
    
    private static void addEdge(int src, int dest) {
    	possibleConnections[src].add(dest);
    	possibleConnections[dest].add(src);
    }
    
    private static List<Integer> findConnections(int[][] cities, int numOfCities) {
    	boolean[] visited = new boolean[numOfCities+1];
    	List<Integer> connections = new ArrayList<>();
    	
    	for(int i=1; i<=numOfCities; i++) {
    		if(!visited[i]) {
    			int c = 1;
    			c = visit(i, visited, c);
    			connections.add(c);
    		}
    	}
    	return connections;
    }
    
    private static int visit(int origin, boolean[] visited, int c) {
		visited[origin] = true;
		
		for(int city : possibleConnections[origin]) {
			if(!visited[city]) {
				c = 1 + visit(city, visited, c);
			}
		}
		
		return c; // count of connected cities
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
