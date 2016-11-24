package com.parvin.leetcodeQuestions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TopStudent implements Comparable<Object>{
   private int id;
   private String fname;
   private double cgpa;
   public TopStudent(int id, String fname, double cgpa) {
      super();
      this.id = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getId() {
      return id;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
   
   @Override
	public int compareTo(Object o) {
		TopStudent s = (TopStudent) o ;
		if(this.cgpa == s.cgpa){
			if(this.fname.equals(s.fname)){
				return (s.id < this.id) ? -1 : 1 ;
			}else{
				return this.fname.compareToIgnoreCase(s.fname);
			}
		}else{
			return (s.cgpa < this.cgpa) ? -1 : 1 ;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
	      Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      
	      List<TopStudent> studentList = new ArrayList<TopStudent>();
	      while(testCases>0){
	         int id = in.nextInt();
	         String fname = in.next();
	         double cgpa = in.nextDouble();
	         if(cgpa>4){
	        	 testCases--;
	        	 continue;
	         }
	         TopStudent st = new TopStudent(id, fname, cgpa);
	         studentList.add(st);
	         
	         testCases--;
	      }
	      	Collections.sort(studentList);
	         for(TopStudent st: studentList){
	         System.out.println(st.getFname());
	      }
	   }
	
}

