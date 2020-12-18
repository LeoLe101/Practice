package src.Leetcode.Problems;

public class LC122BestTimeToBuySellStockII {

	// Space (1) Times (N)
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


	// Greedt pair-wise
	public int maxProfit2(int[] prices) {

		int profit = 0, i = 0;

		while (i <  prices.length) {
		
			// Find next local minimum
			while (i < prices.length - 1 && prices[i+1] <= prices[i])
				i++;

			// Need increment to avoid infinite loop for '[1]'
			int min = prices[i++];

			// Find next local maximum
			while (i < prices.length - 1 && prices[i + 1] >= prices[i])
				i++;

			profit += i < prices.length ? prices[i++] - min : 0;
		}
		return profit;
	}
}
