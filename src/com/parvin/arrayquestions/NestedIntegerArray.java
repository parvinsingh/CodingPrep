package com.parvin.arrayquestions;
import java.util.List;

/**
 * For the given nested array
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one *2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and *one 6 at depth 3)
 * @author ppanesar
 *
 */
public class NestedIntegerArray{

	private static int sum = 0;
	
	public int depthSum(List<?> input){
		return findDepthSum(input, 1);
		
	}

	private int findDepthSum(List<?> input, int depth) {
		for(int i=0; i < input.size(); i++){
			if(input.get(i) instanceof List<?>){
				findDepthSum((List<?>)input.get(i), depth+1);
			}else{
				sum += ((Integer) input.get(i)*depth);
			}
		}
		return sum;
	}

	
}
