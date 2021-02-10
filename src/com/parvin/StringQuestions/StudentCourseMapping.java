package com.parvin.StringQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StudentCourseMapping {

	public static void main(String args[]) {
		String[][] input = {
				{"98", "Human Science"},
				{"54", "Political Science"},
				{"17", "Operating System"},
				{"54", "Human Science"},
				{"10", "Computer Science"},
				{"17", "Human Science"},
				{"98", "Computer Science"}
		};
		
		HashMap<String, LinkedList<String>> result = commonCourses(input);
		for(String id: result.keySet()) {
			System.out.print(id + "-> {");
			for(String s: result.get(id)) {
				System.out.print(s + " ,");
			}
			System.out.println("}");
		}
	}
	
	private static HashMap<String, LinkedList<String>> commonCourses(String[][] input){
		if(input.length == 0) {
			//return new ArrayList<String[]>();
		}
		HashMap<String, LinkedList<String>> courseMap = new HashMap<String, LinkedList<String>>();
		for(int i=0; i<input.length; i++) {
			String id = input[i][0];
			if(!courseMap.containsKey(id)) {
				courseMap.put(id, new LinkedList<String>());
			}
			LinkedList<String> courses = courseMap.get(id);
			courses.add(input[i][1]);
		}
		List<String> students = new ArrayList<>(courseMap.keySet());
		HashMap<String, LinkedList<String>> resultMap = new HashMap<String, LinkedList<String>>();
		
		for(int i=0; i<students.size(); i++) {
			String student1 = students.get(i);
			List<String> c1 = courseMap.get(student1);
			
			for(int j=i+1; j<students.size(); j++) {
				String student2 = students.get(j);
				List<String> c2 = courseMap.get(student2);
				LinkedList<String> result = new LinkedList<String>();
				
				for(String c : c1) {
					if(c2.contains(c)) {
						result.add(c);
					}
				}
				String key = student1 + "--" + student2;
				resultMap.put(key, result);
			}
		}
		return resultMap;
	}
	
}
