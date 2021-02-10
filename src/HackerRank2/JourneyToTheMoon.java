package HackerRank2;

import java.util.LinkedList;
import java.util.List;

//https://www.hackerrank.com/challenges/journey-to-the-moon/problem 

public class JourneyToTheMoon {

	private static LinkedList<Integer>[] astronauts;
	
	public static int journeyToMoon(int n, int[][] input) {
		astronauts = new LinkedList[n];
		
		for(int i=0; i<n; i++) {
			astronauts[i] = new LinkedList<Integer>();
		}
		
		// add Adjacent Astronauts
		for(int i=0; i<input.length; i++) {
			addEdge(input[i][0], input[i][1]);
		}
		
		List<Integer>[] grouped = groupAstronauts(n, input);
		
		int pairs = 0;
		
		for(int g=0; g<grouped.length-1; g++) {
			for(int h=g+1; h<grouped.length; h++) {
				if(grouped[g]!=null && grouped[h]!=null) {
					pairs = pairs + (grouped[g].size() * grouped[h].size());	
				}
			}
		}
		
		return pairs;
		
	}
	
	private static List<Integer>[] groupAstronauts(int n, int[][] input) {
		boolean[] visited = new boolean[n];
		LinkedList<Integer>[] group = new LinkedList[n];
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				group[i] = new LinkedList<Integer>();
				visit(i, group[i], visited);
			}
		}
		return group;
	}

	private static void visit(int i, List<Integer> group, boolean[] visited) {
		visited[i] = true;
		group.add(i);
		for(int a: astronauts[i]) {
			if(!visited[a]) {
				visit(a, group, visited);
			}
		}
	}

	private static void addEdge(int src, int dest) {
		astronauts[src].add(dest);
		astronauts[dest].add(src);
	}
}
