package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.List;

public class FindConnectedCities {

	public static void main(String args[]) {
		List<Integer> origin = new ArrayList<Integer>() {
			{
				add(4);
				add(1);
				add(4);
				add(3);
				add(6);
			}
		};//41436

		List<Integer> destination = new ArrayList<Integer>() {
			{
				add(4);
				add(3);
				add(6);
				add(2);
				add(5);
			}
		};//43625

		List<Integer> output = connectedCities(6, 0, origin, destination);
		for (int i : output) {
			System.out.print(i + ",");
		}
	}

	// Connected cities
	// output 1 if the two cities are connected - cities are connected when they
	// have a GreatestCommonDivisor > threshold.
	public static List<Integer> connectedCities(int numCities, int threshold, List<Integer> originCities,
			List<Integer> destinationCities) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < originCities.size(); i++) {
			if (isThereAPath(originCities.get(i), destinationCities.get(i), threshold)) {
				output.add(1);
				continue;
			}
			output.add(0);
		}
		return output;
	}

	private static boolean isThereAPath(int a, int b, int threshold) {
		if (threshold == 0) {
			return true;
		}
		int t = 2;
		while (true) {
			if (a % t == 0 && b % t == 0 && threshold < t) {
				return true;
			} else if (threshold < t) {
				return false;
			}
			t = t * 2;
		}
	}
}
