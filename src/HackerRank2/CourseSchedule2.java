package HackerRank2;

import java.util.LinkedList;

//https://leetcode.com/problems/course-schedule/

public class CourseSchedule2 {
	
	public static void main(String args[]) {
 		int[][] courses = {{0,1},{0,2},{2,1},{3,4}}; // {{1,2},{2,0},{3,2},{1,0}}; //{{1,0}}; //{{1,0},{2,0}};
 		//System.out.println(CanCoursesBeDone(3, courses));
 		
 		int[] courseOrder = OrderOfCourses(5, courses);
 		for(int i : courseOrder) {
 			System.out.print(i + ",");
 		}
 	}

	public static boolean CanCoursesBeDone(int num, int[][] prereq) {
		if(prereq.length == 0 || prereq.length == 1) {
			return true;
		}
		
		int[] numOfDependency = new int[num];
		
		for(int i=0; i<num; i++) {
			numOfDependency[i] = 0;
		}
		
		//find the number of preRequisites for each course
		for(int i=0; i<prereq.length; i++) {
			int idx = prereq[i][0];
			numOfDependency[idx]++;
		}
		
		//now find the course without a preReq and put in a list
 		LinkedList<Integer> queue = new LinkedList<Integer>();
 		for(int i=0; i<num; i++) {
 			if(numOfDependency[i]==0) {
 				queue.add(i);
 			}
 		}
 		
 		while(!queue.isEmpty()) {
 			int c = queue.remove();//course is done
 			num--;
 			for(int i=0; i<prereq.length; i++) {
 				if(prereq[i][1] == c) {
 					numOfDependency[prereq[i][0]]--;
 					if(numOfDependency[prereq[i][0]]==0) {
 						queue.add(prereq[i][0]);
 					}
 				}
 			}
 		}
 		
 		return num == 0;
	}
	
	public static int[] OrderOfCourses(int num, int[][] prereq) {
		if(prereq.length == 0) {
			return new int[1];
		}
		
		int[] numOfDependency = new int[num];
		
		for(int i=0; i<num; i++) {
			numOfDependency[i] = 0;
		}
		
		//find the number of preRequisites for each course
		for(int i=0; i<prereq.length; i++) {
			int idx = prereq[i][0];
			numOfDependency[idx]++;
		}
		
		//now find the course without a preReq and put in a list
 		LinkedList<Integer> queue = new LinkedList<Integer>();
 		for(int i=0; i<num; i++) {
 			if(numOfDependency[i]==0) {
 				queue.add(i);
 			}
 		}
 		int[] courseOrder = new int[num];
 		int idx = 0;
 		while(!queue.isEmpty()) {
 			int c = queue.remove();//course is done
 			courseOrder[idx] = c;
 			for(int i=0; i<prereq.length; i++) {
 				if(prereq[i][1] == c) {
 					numOfDependency[prereq[i][0]]--;
 					if(numOfDependency[prereq[i][0]]==0) {
 						queue.add(prereq[i][0]);
 					}
 				}
 			}
 			idx++;
 		}
 		
 		return courseOrder;
	}
}
