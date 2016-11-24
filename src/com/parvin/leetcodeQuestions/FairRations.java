package com.parvin.leetcodeQuestions;

import java.util.Scanner;

public class FairRations {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int Bi=0; Bi < N; Bi++){
            B[Bi] = in.nextInt();
        }
        int result = fairRationDistribution(B);
        if(result == -1){
        	System.out.println("NO");
        }else{
        	System.out.println(result);
        }
    }

	private static int fairRationDistribution(int[] b) {
		int bread = 0;
		
		for(int i=0; i<b.length-1; i++){
			if(b[i]%2!=0){
				//if odd
				b[i]++;
				b[i+1]++;
				bread = bread + 2;
			}
		}
		int sum=0;
		for(int j=0; j<b.length; j++){
			//check if after distribution, the sum of breads with all 
			//people is ODD or EVEN
			sum=sum+b[j];
		}
		if(sum%2!=0){
			return -1;
		}
		return bread;
	}
	
	
}