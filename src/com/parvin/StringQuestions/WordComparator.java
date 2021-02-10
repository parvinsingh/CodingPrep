package com.parvin.StringQuestions;

public class WordComparator implements Comparable<WordComparator>{

	String word;
    int count;
    
	public WordComparator(String word, int count)
    {
        this.word = word;
        this.count= count;
    }
	
	@Override
	public int compareTo(WordComparator o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
