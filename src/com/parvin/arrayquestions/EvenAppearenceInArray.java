package com.parvin.arrayquestions;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Given an array find the first integer that appears even number of times
 * @author ppanesar
 *
 */
public class EvenAppearenceInArray {

	public static void main(String args[]){
		int[] input = {3,2,7,7,2,3,3,3};
		evenAppearence(input);
	}

	private static void evenAppearence(int[] array) {
		LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<Integer, Boolean>();
		for(int input: array){
			if(map.get(input)==null){
				map.put(input, false);
			}else{
				Boolean b = map.get(input);
				if(b == false){
					map.put(input, true);
				}else{
					map.put(input, false);
				}
			}
		}
		for(int input: array){
			if(map.get(input)==true){
				System.out.print(input);
				break;
			}
		}
	}
}
