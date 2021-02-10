package HackerRank2;

import java.util.HashMap;

//https://www.hackerrank.com/challenges/weighted-uniform-string/problem

public class WeightedUniformStrings {

	public static void main(String args[]) {
		String s = "aaabbbbcccddd";
		int[] queries = {9,7,12,8,5};
		String[] result = weightedUniformStrings(s, queries);
		for(String str : result) {
			System.out.println(str);	
		}
	}
	
	//s= aabbbccccd
	public static String[] weightedUniformStrings(String s, int[] queries) {
		String[] result = new String[queries.length]; 
		char[] chars = s.toCharArray();
		
		char prev = chars[0];
		int prevW = prev-'a'+1;
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i : queries)
		{
			map.put(i, "NO");
		}
		
		for(int i=1; i<chars.length; i++) {
			if(map.containsKey(prevW)) {
				map.replace(prevW, "YES"); //O(1)
			}
			
			char next = chars[i];
			int nextW = next-'a'+1;
			if(prev == next) {
				prevW = prevW + nextW;
			}else {
				prevW = nextW;
				prev = next;
			}
		}
		
		if(map.containsKey(prevW)) {
			map.replace(prevW, "YES");
		}
		
		for(int i=0; i< queries.length; i++) {
			if(map.containsKey(queries[i])) {
				result[i] = map.get(queries[i]);
			}
		}
		
		return result;
	}
}
