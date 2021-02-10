package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. 
If two words have the same frequency, then the word with the lower alphabetical order 
comes first.
 * @author papanesa
 *
 */
public class TopKFrequentWords {
	
	public static void main(String args[]) {
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		List<String> result = topKFrequent(words);
		int idx = 0;
		while(idx < k) {
			System.out.println(result.get(idx));
			idx++;
		}
		System.out.println("------------------");
		List<String> result2 = topKFrequent(words);
		int idx2 = 0;
		while(idx2 < k) {
			System.out.println(result2.get(idx2));
			idx2++;
		}
	}
	
	private static List<String> topKFrequent(String[] words) {
		//put everything in hashmap
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for(String w:words) {
			wordMap.put(w, wordMap.getOrDefault(w, 0)+1);
		}
		List<String> frequentWords = new ArrayList<>(wordMap.keySet());
		
		Collections.sort(frequentWords, 
				(w1,w2) -> wordMap.get(w1).equals(wordMap.get(w2)) 
					? w1.compareTo(w2) : wordMap.get(w2)-wordMap.get(w1));
		
		return frequentWords;
        
    }

	//using TreeMap
	@SuppressWarnings("unchecked")
	private static List<String> topKFrequentUsingTreeMap(String[] words) {
		//put everything in hashmap
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		
		for(String w:words) {
			wordMap.put(w, wordMap.getOrDefault(w, 0)+1);
		}
		List<String> frequentWords = new ArrayList<>(wordMap.keySet());
		
		Collections.sort(frequentWords, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				String w1 = (String)o1;
				String w2 = (String)o2;
				
				return wordMap.get(w1).equals(wordMap.get(w2)) 
						? w1.compareTo(w2) : wordMap.get(w2)-wordMap.get(w1);
			}
		});
		
		return frequentWords;
        
    }
}
