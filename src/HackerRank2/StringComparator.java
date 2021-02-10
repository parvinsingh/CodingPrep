package HackerRank2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/*
 * compare the strings based on frequency, and if frequency match
 * compare them lexicographically.
 * 
 */

public class StringComparator {

	public static void main(String args[]) {
		String[] input = {"redhat", "pinkShirt", "bluepants", "redhat", "pinkShirt", "yellowBottoms",
				"bluepants", "redhat","whiteShirt", "whiteShirt", "redhat", "pinkShirt"};
		String result = PopularString(input);
		System.out.println(result);
	}
	
	public static String PopularString(String[] input) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(String p: input) { //put everything in the map to get the frequency
			int c = map.getOrDefault(p, 0);
			map.put(p, c+1);
		}
		
//		//create a custom comparator to compare on value and then alphabetically
		ValueComparator<String, Integer> valComparator =
				new ValueComparator<String, Integer>(map);
//		
//		//use TreeMap to compare keys and values both
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(valComparator);
//		//put everything in the TreeMap to maintain the alphabetic order and order by frequency
		sortedMap.putAll(map);
		
		List<String> sortedList = new ArrayList<String> (sortedMap.keySet());

		//line 44- 47 is another way to do this, without TreeMap
		List<String> frequentWords = new ArrayList<>(map.keySet());
		
		Collections.sort(frequentWords, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				String w1 = (String)o1;
				String w2 = (String)o2;
				
				return map.get(w1).equals(map.get(w2)) 
						? w1.compareTo(w2) : map.get(w1)-map.get(w2);
			}
		});
		System.out.println(frequentWords);
		
		
		System.out.println(sortedMap);
		System.out.println(sortedList);
		
		return frequentWords.get(frequentWords.size()-1);
	}
	
	static class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

		HashMap<K, V> map;

		public ValueComparator(HashMap<K, V> base) {
		    this.map = base;
		}

		@Override
		public int compare(K o1, K o2) {
			String k1 = (String) o1;
			String k2 = (String) o2;
		     int result = map.get(o1).compareTo(map.get(o2));
		     return result != 0 ? result : k1.compareToIgnoreCase(k2);
		}
	}
}
