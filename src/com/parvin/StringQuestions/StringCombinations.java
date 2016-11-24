package com.parvin.StringQuestions;
import java.util.ArrayList;



public class StringCombinations {

	public static void main(String args[]){
		String[] str1 = {"old","young","new"};
		String[] str2 = {"brown","black","white"};
		//String[] str3 = {"fox","dog","wolf"};
		ArrayList<String[]> input = new ArrayList<>();
		input.add(str1);
		input.add(str2);
//		input.add(str3);
		combine(input, 0, new ArrayList<String>());
	}
	
	private static void combine(ArrayList<String[]> input, int index, ArrayList<String> output) {
			if(index==input.size()){
				for(String str : output){
					System.out.print(str + " ");
				}
				System.out.println();
			}else{
				String[] workingStr = input.get(index);
				for(int i=0; i<workingStr.length; i++){
					output.add(workingStr[i]);
					combine(input, index+1, output);
					output.remove(workingStr[i]);
				}
			}
	}
}
