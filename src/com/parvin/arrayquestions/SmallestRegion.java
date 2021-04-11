package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given some lists of regions where the first region of each list
 * includes all other regions in that list. Naturally, if a region X contains
 * another region Y then X is bigger than Y. Also by definition a region X
 * contains itself. Given two regions region1, region2, find out the smallest
 * region that contains both of them. If you are given regions r1, r2 and r3
 * such that r1 includes r3, it is guaranteed there is no r2 such that r2
 * includes r3.
 * 
 * It's guaranteed the smallest region exists.
 * 
 * @author papanesa
 *
 *         Input: regions = [["Earth","North America","South America"], ["North
 *         America","United States","Canada"], ["United States","New
 *         York","Boston"], ["Canada","Ontario","Quebec"], ["South
 *         America","Brazil"]], region1 = "Quebec", region2 = "New York" Output:
 *         "North America"
 *
 */
public class SmallestRegion {

	public static void main(String args[]) {
		
		List<List<String>> regionsList = Arrays.asList(
										Arrays.asList("Earth","North America","South America"),
										Arrays.asList("North America","United States","Canada"),
										Arrays.asList("United States","New York","Boston"),
										Arrays.asList("Canada","Ontario","Quebec"),
										Arrays.asList("South America","Brazil"));
		String region1 = "North America";
		String region2 = "South America";
		String result = findSmallestCommonRegion(regionsList, region1, region2);
		System.out.println("region1= "+ region1 + " region2= " + region2 + " common region = " + result);
	}

	private static String findSmallestCommonRegion(List<List<String>> regionsList, String region1, String region2) {
		
		while(!region1.equalsIgnoreCase(region2)) {
			for(List<String> regions : regionsList) {
				if(regions.contains(region1)) {
					region1 = regions.get(0);
				}
				if(regions.contains(region2)) {
					region2= regions.get(0);
				}
				if(region1.equalsIgnoreCase(region2)) {
					return region1;
				}
			}
		}
		return region1;
	}}
