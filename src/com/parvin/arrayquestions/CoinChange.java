package com.parvin.arrayquestions;

/**
 * Given an amount, and an array of Coins, output
 * the number of ways the amount can be formed using the coins.
 * @author papanesa
 *
 */
public class CoinChange {

	public static void main(String args[]) {
		int[] coins = {1,2,5};
		int amount = 6;
		System.out.println(waysToFormAmount(coins, amount, coins.length));
	}
//6    1,2,5
	private static int waysToFormAmount(int[] coins, int amount, int len) {
		if(amount == 0) {
			return 1;//only 1 way, do not include any coin
		}
		
		if(amount < 0) {
			return 0;
		}
		
		if(len <= 0 && amount >= 1) {
			return 0;
		}
		
		return waysToFormAmount(coins, amount, len-1) //exclude the last coin
				+ waysToFormAmount(coins, amount-coins[len-1], len);//include the last coin
	}
}
