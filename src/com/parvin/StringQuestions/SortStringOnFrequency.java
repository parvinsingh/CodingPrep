package com.parvin.StringQuestions;
import java.util.Collections;



public class SortStringOnFrequency {

	public static void main(String args[]){
		sortBasedOnFrequency("teerrr");
	}
	
	public static void sortBasedOnFrequency(String input){
		String temp = input;
	    java.util.List<Pair> list = new java.util.ArrayList<Pair>();
	    while(temp.length() != 0)
	    {
	        list.add(new Pair(temp.charAt(0), countOccurrences(temp, temp.charAt(0))));
	        temp = temp.replaceAll(String.valueOf(temp.charAt(0)),"");
	    }
		Collections.sort(list);
		for(Pair p: list){
			for(int i=1; i<= p.getCount(); i++){
				System.out.print(p.getLetter());
			}
		}
	}
	
	private static int countOccurrences(String temp, char charAt) {
		int count = 0;
	    for(int i = 0; i < temp.length(); i++)
	    {
	        if(temp.charAt(i) == charAt) count++;
	    }
	    return count;
	}
	
}
