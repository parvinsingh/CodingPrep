package com.parvin.leetcodeQuestions;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/journey-to-the-moon/problem

public class JourneyToTheMoon {
	
	protected static int astronautPairs(int[][] input, int n) {
		LinkedList<Integer>[] astronauts = new LinkedList[n];
		//create adjacency list
		for(int i=0; i<n; i++) {
			astronauts[i] = new LinkedList<Integer>();
		}
		
		createAdjacencyList(input, astronauts);
		
		List<Integer>[] groups = createGroups(n, astronauts);
		
		int pairs = 0;
		//loop over the grouping
		for(int i=0; i<groups.length-1; i++) {
			for(int j=i+1; j<groups.length; j++) {
				if(groups[i] != null && groups[j] != null) {
					pairs = pairs + (groups[i].size() * groups[j].size());	
				}
			}
		}
		return pairs;
	}

	private static LinkedList<Integer>[] createGroups(int n, LinkedList<Integer>[] astronauts) {
		boolean[] visited = new boolean[n];
		LinkedList<Integer>[] list = new LinkedList[n];
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				list[i] = new LinkedList<Integer>();
				visitOthers(i, list[i], visited, astronauts);
			}
		}
		return list;
	}

	private static void visitOthers(int astronaut, LinkedList<Integer> list, 
			boolean[] visited, LinkedList<Integer>[] astronauts) {
		visited[astronaut] = true;
		list.add(astronaut);
		for(int x: astronauts[astronaut]) {
			if(!visited[x]) {
				visitOthers(x, list, visited, astronauts);
			}
		}
	}

	private static void createAdjacencyList(int[][] input, LinkedList<Integer>[] astronauts) {
		for(int i=0; i<input.length; i++) {
			astronauts[input[i][0]].add(input[i][1]);
			astronauts[input[i][1]].add(input[i][0]);
		}
	}
}
