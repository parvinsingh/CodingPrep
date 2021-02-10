package com.parvin.leetcodeQuestions;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Given a list of projects and a list of dependencies
 * dependencies -> list of pairs of projects, where the second project is dependent on first project
 * All of porject dependencies must be built before the project is.
 * Find the build order.
 * Input:
 * Projects -> a,b,c,d,e,f
 * dependencies -> {{a,d},{f,b},{b,d},{f,a},{d,c}}
 * output -> f,e,b,a,d,c
 **/
public class ProjectBuildOrder {
	
	public static void main(String args[]) {
		String[] projects = {"a","b","c","d","e","f"};
		String[][] dependencies = {{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};
		String[] result = projectBuildOrder(projects, dependencies);
		for(String p: result) {
			System.out.print(p + ",");
		}
	}

	private static String[] projectBuildOrder(String[] projects, String[][] dependencies) {
		int len = dependencies.length;
		HashMap<String, Integer> counterMap = new HashMap<String, Integer>();
		for(int i=0; i<projects.length; i++) {
			counterMap.put(projects[i], 0);
		}
		
		for(int i=0; i<len; i++) {
			int c = counterMap.get(dependencies[i][1]);
			counterMap.put(dependencies[i][1], ++c);
		}
		int projectsBuilt = 0;
		LinkedList<String> queue = new LinkedList<String>();
		
		for(String p: counterMap.keySet()) {
			if(counterMap.get(p)==0) {
				projectsBuilt++;
				queue.add(p);
			}
		}
		
		String[] result = new String[projects.length];
		int idx = 0;
		while(!queue.isEmpty()) {
			String top = queue.remove();
			result[idx++] = top;
			for(int i=0; i<len; i++) {
				if(top == dependencies[i][0]) {
					int c = counterMap.get(dependencies[i][1]);
					counterMap.put(dependencies[i][1], --c);
					if(c == 0) {
						queue.add(dependencies[i][1]);
						projectsBuilt++;
					}
				}
				
			}
		}
		return (projectsBuilt == projects.length) ? result : new String[1];
	}
}
