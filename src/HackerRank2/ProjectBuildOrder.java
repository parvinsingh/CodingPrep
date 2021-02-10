package HackerRank2;

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
		
		HashMap<String, Integer> projCounter = new HashMap<String, Integer>();
		for(int i=0; i<projects.length; i++) {
			projCounter.put(projects[i], 0);
		}
		
		//num of dependencies per project
		for(int i=0; i<dependencies.length; i++) {
			int count = projCounter.get(dependencies[i][1]);
			projCounter.put(dependencies[i][1], count+1);
		}
		
		//find project without dependency
		LinkedList<String> queue = new LinkedList<String>();
		
		for(int i=0; i<projects.length; i++) {
			if(projCounter.get(projects[i])==0) {
				queue.add(projects[i]);
			}
		}
		String[] result = new String[projects.length];
		int idx = 0;
		
		while(!queue.isEmpty()) {
			String top = queue.remove();
			result[idx] = top;
			for(int i=0; i<dependencies.length; i++) {
				String first = dependencies[i][0];
				String second = dependencies[i][1];
				if(first == top) {
					int c = projCounter.get(second);
					projCounter.put(second, c-1);
					if(projCounter.get(second) == 0) {
						queue.add(second);
					}
				}
			}
			idx++;
		}
		
		return result;
	}
	
}
