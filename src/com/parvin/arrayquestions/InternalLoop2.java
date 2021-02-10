package com.parvin.arrayquestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//this solution is not working
//alternately I can use elimiation technique to make it work- by 
//using map of String and all remaining nodes, and then eliminating one at a time.

public class InternalLoop2 {

	/*
	 * Input
		A B  #A != B 
		B C
		C D
		A D  #A != D       BD , AC     2n
		
		true
		{A C} {B D}
		
		
		adjacency List
		A - B,D
		B - C
		C - B,D
		D - A
		
		input
		A B   
		A C   O(2n)   
		
		HashMap<char, List<Characters>> map 
		
		O(n^2)- n: no of edges
		forloop of number of Pairs{
		input[i][0]
		
		input[i][1]
		}
	 */
	public static boolean groupMatches(String[][] input, int vertices) {
		HashMap<String,LinkedList<String>> adjacencyMap = new HashMap<String, LinkedList<String>>();
		
		 
		for(int i=0; i<input.length; i++) {
			LinkedList<String> source = adjacencyMap.getOrDefault(input[i][0], new LinkedList<String>());
			source.add(input[i][1]);
			
			LinkedList<String> destination = adjacencyMap.getOrDefault(input[i][1], new LinkedList<String>());
			destination.add(input[i][0]);
			
			adjacencyMap.put(input[i][0], source);
			adjacencyMap.put(input[i][1], destination);
		}
		
		return searchpairs(adjacencyMap, vertices);
	}

	private static boolean searchpairs(HashMap<String,LinkedList<String>> adjacencyMap, int vertices) {
		//will use 1=true, 0=false;
		int[] visited = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(String key: adjacencyMap.keySet()) {
			visited[Character.getNumericValue('z') - Character.getNumericValue(key.charAt(0))] = 0;
		}
		
		StringBuffer strbuff = new StringBuffer();
		List<String> result = new LinkedList<String>();
		
		for(String key: adjacencyMap.keySet()) {
			char ch = key.charAt(0);
			strbuff.append(key);
			List<String> originalNeighbors = adjacencyMap.get(key);
			if(visited[Character.getNumericValue(ch)] == 0) {
				//visit its neighbors
				result.add(bfsUtil(key, adjacencyMap, visited, strbuff, originalNeighbors));
			}
		}
		return result.size()==2 ? true: false;
	}
	
	private static String bfsUtil(String v, HashMap<String,LinkedList<String>> adjacencyMap, int[] visited, StringBuffer groups, List<String> originalNeighbors) {
		visited[Character.getNumericValue(v.charAt(0))] = 1;
		
		
		for(String s : adjacencyMap.get(v)) {//get neighbors
			if(visited[Character.getNumericValue(s.charAt(0))] == 0) {
				if(!originalNeighbors.contains(s)) {
					groups.append(s);
				}
				bfsUtil(s, adjacencyMap, visited, groups, originalNeighbors);
			}
		}
		
		return groups.toString();
	}
	
	public static void main(String args[]) {
		String[][] input = {{"a","b"},{"b","c"},{"c","d"},{"a","d"}};
		boolean result = groupMatches(input, 4);
	}
}


