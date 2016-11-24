package com.parvin.interviewprep;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Dequeue {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int subArrSize = m;
        int[] temp = new int[m];
        for (int i = 0; i < n; i++) {
            
                int num = in.nextInt();
                temp[subArrSize-1]=num;
            
            subArrSize--;
            if(subArrSize==0){
                deque.addLast(temp);
                subArrSize=m;
            }
        }
        
    }
}
