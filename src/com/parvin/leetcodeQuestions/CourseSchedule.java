package com.parvin.leetcodeQuestions;

import java.util.LinkedList;

//https://leetcode.com/problems/course-schedule/

public class CourseSchedule {

	 	public static void main(String args[]) {
	 		int[][] courses = {{1,2},{2,0},{3,2},{1,0}}; // {{1,0},{2,0}}; // //
	 		System.out.println(CanCoursesBeDone(4, courses));
	 		
//	 		int[] courseOrder = OrderOfCourses(2, courses);
//	 		for(int i : courseOrder) {
//	 			System.out.print(i + ",");
//	 		}
	 	}
	 	
	 	/*
	 	 * Input: numCourses = 2, prerequisites = [[1,0],[2,0],[3,1]]
	 	 *	Output: false
	 	 *	To do Course#1, Course#0 needs to be done
	 	 */
	 	private static boolean CanCoursesBeDone(int num, int[][] courses) {
	 		if(courses.length == 0 || courses.length == 1) {
	 			return true;
	 		}
	 		
	 		int len = courses.length;
	 		
	 		//find the number of preRequisites for each course
	 		int[] pCounter = new int[num];
	 		for(int i=0; i<len; i++) {
	 			pCounter[courses[i][0]]++;
	 		}
	 		
	 		//now find the course without a preReq and put in a list
	 		LinkedList<Integer> queue = new LinkedList<Integer>();
	 		for(int i=0; i<num; i++) {
	 			if(pCounter[i]==0) {
	 				queue.add(i);
	 			}
	 		}
	 		int numOfCompletedCourse = queue.size();
	 		while(!queue.isEmpty()) {
	 			int top = queue.remove();
	 			//now check which all courses have the top course as preReq
	 			for(int i=0; i<len; i++) {
	 				if(top == courses[i][1]) {
	 					pCounter[courses[i][0]]--;
	 					//put the course in Queue, because that can now be marked complete
	 					if(pCounter[courses[i][0]] == 0) {
		 					queue.add(courses[i][0]);
		 					numOfCompletedCourse++;
	 					}
	 				}
	 			}
	 		}
	 		return numOfCompletedCourse == num;
	 	}
	 	
	 	private static int[] OrderOfCourses(int num, int[][] courses) {
	 		if(courses.length == 0) {
	 			return new int[1];
	 		}
	 		
	 		int len = courses.length;
	 		
	 		//find the number of preRequisites for each course
	 		int[] pCounter = new int[num];
	 		for(int i=0; i<len; i++) {
	 			pCounter[courses[i][0]]++;
	 		}
	 		
	 		//now find the course without a preReq and put in a list
	 		LinkedList<Integer> queue = new LinkedList<Integer>();
	 		for(int i=0; i<num; i++) {
	 			if(pCounter[i]==0) {
	 				queue.add(i);
	 			}
	 		}
	 		int numOfCompletedCourse = queue.size();
	 		int[] result = new int[num];
	 		int idx = 0;
	 		while(!queue.isEmpty()) {
	 			int top = queue.remove();
	 			result[idx++] = top;
	 			//now check which all courses have the 'top' course as preReq
	 			for(int i=0; i<len; i++) {
	 				if(top == courses[i][1]) {
	 					pCounter[courses[i][0]]--;
	 					//put the course in Queue, because that can now be marked complete
	 					if(pCounter[courses[i][0]] == 0) {
		 					queue.add(courses[i][0]);
		 					numOfCompletedCourse++;
	 					}
	 				}
	 			}
	 		}
	 		return (numOfCompletedCourse == num)? result: new int[1];
	 	}
}
