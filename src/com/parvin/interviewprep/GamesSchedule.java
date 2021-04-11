package com.parvin.interviewprep;

//print the players schedule for the match.
/*
 * Given number of players, num of Games per match, and numOfMatches
 * find and return the players schedule who will play in the games.
 * For example, players=3, games=2, matches=5
 * the schedule will look like:
 * P1,P2 will play in the first match
 * P3,P1 will play in the second match and so on.
 *
 *	The difference between a player playing the most matches, and player playing
 *	the least matches will not be more than 1.
 */

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
		
		String[] result2 = matchSchedule(3, 2, 5);
		printArray(result2);
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
