package com.parvin.interviewprep;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ 

public class StockBuySellProfit {
	
	public static void main(String args[]) {
		int nums[] = {100, 180, 260, 310, 40, 535, 695};
		int nums1[] = {1,2,3,4,5};
		int nums2[] = {1, 4, 5, 7, 6, 3, 2, 9};
		int nums3[] = {6,0,-1,10};
		int nums4[] = {10,3,3,5,0,0,3,1,4};
		int nums5[] = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit2(nums3));
	}

	//Only one transaction is allowed
	private static int maxProfit(int[] prices) {
		int profit = 0;
		int buyPrice = prices[0]; //min price to buy the stock
		for(int i=1; i< prices.length; i++) {
			buyPrice = Math.min(buyPrice, prices[i]);
			profit = Math.max(profit, (prices[i]-buyPrice));
		}
		return profit;
	}
	
	//two transactions are allowed at the most
	private static int maxProfit2(int[] prices) {
		int profit = 0;
		
		int[] leftProfit = new int[prices.length];
		leftProfit[0] = 0;
		int leftBuyPrice = prices[0];
		for(int i=1; i< prices.length; i++) {
			leftBuyPrice = Math.min(prices[i], leftBuyPrice);
			leftProfit[i] = Math.max(leftProfit[i-1], (prices[i]-leftBuyPrice));
		}
		
		int[] rightProfit = new int[prices.length];
		rightProfit[prices.length-1] = 0;
		int rightSellPrice = prices[prices.length-1];
		for(int i=prices.length-2; i>=0; i--) {
			rightSellPrice = Math.max(prices[i], rightSellPrice);
			rightProfit[i] = Math.max(rightProfit[i+1], (rightSellPrice-prices[i]));
		}
		
		for(int i=0; i<prices.length; i++) {
			profit = Math.max(profit, leftProfit[i]+rightProfit[i]);
		}
		return profit;
	}
}
