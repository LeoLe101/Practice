package src.Leetcode.Problems;

public class LC122BestTimeToBuySellStockII {

	public int maxProfit(int[] prices) {
		if (prices.length < 1) return 0;

		int len = prices.length;
		int ptr1 = 0;
		int maxProfit = 0, currProfit = 0, currStock = 0, prevStock = 0;

		for (int ptr2 = 1; ptr2 < len; ptr2++) {
			currStock = prices[ptr2];
			prevStock = prices[ptr1];

			if (currStock > prevStock) {
				currProfit = currStock - prevStock;
				maxProfit += currProfit;
			}
			ptr1 = ptr2;
		}
		return maxProfit;
	}

}
