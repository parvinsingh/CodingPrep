package com.parvin.StringQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordAndCharacterOrdering {

	public static void main(String args[]) {
		String[] words = {"hello", "world", "helloo"};
		int k = 4;
		sortingOfWords(words);
		
	}
	
	private static void sortingOfWords(String[] input) {
		List<String> ip = Arrays.asList(input);
		TreeMap<Character, Integer> charMap = new TreeMap<Character, Integer>();
		WordAndCharacterOrdering order = new WordAndCharacterOrdering();
		for(String s: ip) {
			for(int i=0; i<s.length(); i++) {
				charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0)+1);
			}
			printOutput(charMap, order);
			charMap = new TreeMap<Character, Integer>();
		}
	}
	
	private static void printOutput(TreeMap<Character, Integer> charMap, WordAndCharacterOrdering order) {
		LinkedList<Word> words = new LinkedList<Word>();
		for(Map.Entry<Character, Integer> e: charMap.entrySet()) {
			words.add(order. new Word(e));
		}
		Collections.sort(words, (a,b) -> (a.frequency == b.frequency)
				? b.ch.compareTo(a.ch) : b.frequency-a.frequency);
		
		for(Word w: words) {
			System.out.print(w.ch + "-" + w.frequency + ",");
		}
		System.out.println();
	}
	
	class Word {
		Character ch;
		int frequency;
		
		Word(Map.Entry<Character, Integer> e){
			this.ch = e.getKey();
			this.frequency = e.getValue().intValue();
		}
	}
}
