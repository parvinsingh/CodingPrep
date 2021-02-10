package HackerRank2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
	
public class RemoveSubFolders {

	public static void main(String args[]) {
		String[] input = {"/a","/a/aaba","/a/aaaab","/b/acdb","/b/acd"};
		List<String> result = removeSubfolders(input);
		for(String s: result) {
			System.out.println(s);
		}
	}

	//O(N) + O(n logN) -> O(n logN)
	private static List<String> removeSubfolders(String[] input) {
		List<String> inpList = Arrays.asList(input);
		Collections.sort(inpList, (a, b) -> a.compareTo(b));//O nlogN
		List<String> result = new ArrayList<String>();
		
		String first = inpList.get(0);
		for(int i=1; i<inpList.size(); i++) { //O(N)
			String temp = inpList.get(i);
			if(temp.startsWith(first)
					&& temp.replaceFirst(first, "").startsWith("/")) {
				continue;
			}else {
				result.add(first);
				first = temp;
			}
		}
		result.add(first);
		return result;
	}
	
}
