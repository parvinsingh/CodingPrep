package com.parvin.arrayquestions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class findIntegerPairs {
	
	static int numberOfPairs(int[] a, long sum) {
		LinkedList<Integer> unique = new LinkedList<Integer>();
		
		for(int i: a){
			//put everything in the list O(n)
			if(!unique.contains(i)){
				unique.add(i);
			}
		}
		int count=0;
		for(int j=0; j<unique.size()-1; j++){
			//O(n^2) 
			int first = unique.get(j);
			for(int k=j+1; k<unique.size(); k++){
				int second = unique.get(k);
				if(sum==(int)(first+second)){
					count++;
					break;
				}
			}
		}
		return count;
    }
	
	static List<String> numberOfPairsUsingMap(int[] a, int sum) {
		Set<String> set = new HashSet<>();
		List<String> output = new ArrayList<String>();
		
		for(int i: a){
			int complement = sum-i;
			if(!set.add(i+"-"+complement)) {
				output.add(i+"-"+complement);
				continue;//1-7, 3-5, 
			}else if(!set.add(complement+"-"+i)){
				output.add(i+"-"+complement);
				continue;
			}
		}
		return output;
    }

	public static void main(String args[]){
		int[] arr = {2, 3, 7, 3, 5, 0, 8};
		//int[] arr = {1,-1,1,1,1};
		int count = numberOfPairs2(arr, 8);
		List<String> op = numberOfPairsUsingMap(arr, 8);
		System.out.println(count);
		
		for(String s: op) {
			System.out.println(s);
		}
	}
	
	public static int numberOfPairs2(int[] arr, int sum){
		int count = 0;
		ArrayList<Integer> unique = new ArrayList<Integer>();
		for(int i: arr){
			//put everything in the list O(n)
			unique.add(i);
		}//{1,3,11,4,6,9,8}; 
		while(!unique.isEmpty()){
			int index = 0;
			int complement = sum-unique.get(index);
			unique.remove(index);//operation takes O(n) time
			if(unique.contains(complement)){
				count++;
				
				unique.remove(unique.indexOf(complement));
			}
		}
		
		return count;
	}
	
	
	public findIntegerPairs() {
		super();
		// TODO Auto-generated constructor stub
	}


	class UniqueIntPair {
		int firstNum;
		int secondNum;
	}
	
//	public static void main(String[] args) throws IOException{
//        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        int res;
//        
//        int _a_size = 0;
//        _a_size = Integer.parseInt(in.nextLine().trim());
//        int[] _a = new int[_a_size];
//        int _a_item;
//        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
//            _a_item = Integer.parseInt(in.nextLine().trim());
//            _a[_a_i] = _a_item;
//        }
//        
//        long _k;
//        _k = Long.parseLong(in.nextLine().trim());
//        
//        res = numberOfPairs(_a, _k);
//        bw.write(String.valueOf(res));
//        bw.newLine();
//        
//        bw.close();
//    }
}
	

