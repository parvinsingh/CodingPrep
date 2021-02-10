package com.parvin.arrayquestions;
//https://www.hackerrank.com/challenges/kangaroo/problem 

public class KangarooJump {
	
	public static void main(String args[]) {
		boolean result = kangaroo(0,2,5,3);
		System.out.println(result);
	}
	
	private static boolean kangaroo(int x1, int v1, int x2, int v2) {
		if(x1 == x2) {
			return true;
		}
		
		while(x1 != x2 && x1<10000 && x2<10000) {
			x1 = x1+v1;
			x2 = x2+v2;
			
			if(x1 == x2) {
				return true;
			}
		}
		return false;
	}
}
