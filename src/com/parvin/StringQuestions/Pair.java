package com.parvin.StringQuestions;

public class Pair implements Comparable<Pair>
	{
	    char letter;
	    int count;
	    
	    public Pair(char letter, int count)
	    {
	        this.letter = letter;
	        this.count= count;
	    }
	    
	    public char getLetter(){return letter;}
	    public int getCount(){return count;}
	    
		@Override
		public int compareTo(Pair p) {
			if(this.count < p.count){
				return 1;
			}else{
				return -1;
			}
		}
	}