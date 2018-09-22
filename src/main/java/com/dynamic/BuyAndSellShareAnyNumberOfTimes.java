package com.dynamic;

public class BuyAndSellShareAnyNumberOfTimes {

	public static void main(String[] args) {
		int price[] = { 10, 22, 5, 75, 65, 80 };
		findMaxProfit(price);
		int price1[] = { 100, 30, 15, 10, 8, 25, 80 };
		findMaxProfit(price1);
		int price2[] = { 2, 30, 15, 10, 8, 25, 80  };
		findMaxProfit(price2);
		int price3[] = { 90, 80, 70, 60, 50 };
		findMaxProfit(price3);
	}

	private static void findMaxProfit(int[] price) {

		int profit = 0;
		int buy = -1;
		int sale = -1;
		for (int i = 0; i < price.length; i++) {
			if (i + 1 < price.length && buy != -1 && price[i] >= price[i + 1]) {
				sale = price[i];
				profit += sale - buy;
				buy = -1;
				sale = -1;
			} else if (i + 1 < price.length && buy == -1 && price[i] < price[i + 1]) {
				buy = price[i];
			} else if (buy != -1 && i + 1 == price.length) {
				sale = price[i];
				profit += sale - buy;
				buy = -1;
				sale = -1;
			}
		}
		System.out.println(profit);
	}
}
