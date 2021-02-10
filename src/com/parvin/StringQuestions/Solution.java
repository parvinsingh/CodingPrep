package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String args[]) {
		List<String> repo = new ArrayList<String>(Arrays.asList("code", "codephone", "coddle", "coddles", "codes"));
		List<List<String>> result = searchSuggestions(repo, "dog");
		for(List<String> words: result) {
			System.out.println();
		}
	}
	
	public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
	    // Write your code here
	    LinkedHashMap<String, ArrayList<String>> mapping = new LinkedHashMap<String, ArrayList<String>>();
	        for(int i=1; i<customerQuery.length(); i++){
	            ArrayList<String> temp = new ArrayList<String>();
	            mapping.put(customerQuery.substring(0, i+1), temp);
	            for(String word: repository){
	                if(word.startsWith(customerQuery.substring(0, i+1))){
	                    temp.add(word);
	                }
	            }
	        }
	        List<List<String>> result = new ArrayList<List<String>>();
	        for(Map.Entry<String, ArrayList<String>> e : mapping.entrySet())
	        {
	                List<String> values = e.getValue().stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
	                if(values.size()>3){
	                    result.add(values.subList(0, 3));
	                }else{
	                    result.add(values);
	                }
	        }

	        return result;
	    }
	    
}
