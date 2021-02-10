package com.parvin.interviewprep;

//print the players schedule for the match.

public class GamesSchedule {
	//3 -2- 5
	private static String[] matchSchedule(int numOfPlayers, int numOfGames, int numOfMatches){
		String[] result = new String[numOfMatches];
		int pidx = 1;
		for(int i=0; i<numOfMatches; i++) {
			result[i] = "M"+(i+1)+":";
			String player = "";
			int g = 1;
			while(g<=numOfGames) {
				player = player + "P" + pidx + ",";
				pidx++;
				g++;
				if(pidx > numOfPlayers) {
					pidx = 1;
				}
			}
			result[i] = result[i] + player;
		}
		return result;
	}

	public static void main(String args[]) {
		String[] result = matchSchedule(9, 4, 20);
		printArray(result);
	}
	
	private static void printArray(String[] array) {
		String result = "";
		for(String i: array) {
			result = result + i + ", ";
		}
		System.out.print("{");
		System.out.print(result.substring(0, result.length()-1));
		System.out.println("}");
	}
}
