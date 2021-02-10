package com.parvin.StringQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
import java.util.List;

//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

public class SubFolders {

	public static void main(String args[]) {
		//String[] input = {"/a","/a/aaaaa","/a/aaaab","/a/aaaac","/a/aaaad","/a/aaaae","/a/aaaaf"};
		String[] input = {"/a","/a/aaba","/a/aaaab","/b/acdb","/b/acd"};
		List<String> result = removeSubfolders(input);
		for(String s: result) {
			System.out.println(s);
		}
	}
	
	public static List<String> removeSubfolders(String[] folder) {
		List<String> folders = Arrays.asList(folder);
		Collections.sort(folders, (a, b) -> a.compareTo(b));//O(n log n)
		List<String> result = new ArrayList<String>();
		
		String first = folders.get(0);
        for(int i=1; i<folders.size(); i++) {
        	String temp = folders.get(i);
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
