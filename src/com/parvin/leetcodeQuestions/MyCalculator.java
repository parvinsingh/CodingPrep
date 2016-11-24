package com.parvin.leetcodeQuestions;
import java.util.Scanner;

public class MyCalculator{
    
    private int power(int n, int p) throws Exception{
        if(p<0 || n<0){
            throw new Exception("n and p should be non-negative");
        }
        if(p==0){
            return 1;
        }
        int power=n;
        for(int i=0; i<p; i++){
            power=power*n;
        }
        return power;
    }
    
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt())
        {
            int n = in.nextInt();
            int p = in.nextInt();
            MyCalculator M = new MyCalculator();
            try
            {
                System.out.println(M.power(n,p));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
}