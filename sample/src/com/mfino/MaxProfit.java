package com.mfino;

public class MaxProfit {
	public void getMaxProfitSingleSale(int stock[]) {
		int buy = 0, sell = 0, profit = 0, min = 0;
		for(int i = 0; i < stock.length; i++) {
			if(stock[i] < stock[min]) {
				min = i;
			}
			if(profit < (stock[i] - stock[min])) {
				buy = min;
				sell = i;
				profit = stock[i] - stock[min];
			}
		}
		System.out.println("Buy: "+stock[buy]+", Sell: "+stock[sell]+", Profit: "+profit);
	}
	
	public static void main(String args[]) {
		MaxProfit profit = new MaxProfit();
		int stock[] = {100, 120, 90, 140, 110, 150, 70, 100};
		profit.getMaxProfitSingleSale(stock);
	}
}
