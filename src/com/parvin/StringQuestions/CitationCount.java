package com.parvin.StringQuestions;

import java.util.HashMap;
import java.util.List;

public class CitationCount {
/*
 * {"abc-1", "author1", "title1", "[abc-2]"}
{"abc-2", "author3, author2", "title1", "[abc-1]"}
{"abc-3", "author1, author5", "title1", "[abc-5], [abc-2]"}
{"abc-5", "author6", "title1", "[abc-1], [abc-6], [abc-2]"}
{"abc-6", "author7, author2", "title1", "[abc-3], [abc-5], [abc-1]"}
 */
	private static void CountOfCitations(String[] input) {
		int len = input.length;
		HashMap<String, List<String>> pageAuthorMap = 
				new HashMap<String, List<String>>();
		for(int i=0; i<len; i++) {
			//map of ID and authors
			populatePageAuthorMap(input[i], pageAuthorMap);
		}
	}
}
