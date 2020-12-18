package src.Leetcode.Problems;

public class LC121BestTimeToBuySellStockI {

	// Space (1) Time (N)
	public int maxProfit(int[] prices) {

		if (prices.length < 1) return 0;

		int len = prices.length;
		int ptr1 = 0;
		int maxProfit = 0;
		int currProfit = 0;
		int currStock = 0;
		int prevStock = 0;

		// Check with 2 pointers
		// Move the pointer 1 to 2 if val2 > val1
		// Otherwise, check if currProfit is the maxProfit
		for (int ptr2 = 0; ptr2 < len; ptr2++) {
			currStock = prices[ptr2];
			prevStock = prices[ptr1];

			if (currStock < prevStock) {
				ptr1 = ptr2;
			} else {
				currProfit = currStock - prevStock;
				maxProfit = Math.max(maxProfit, currProfit);
			}
		}
		return maxProfit;
	}


	// Space (1) Time (N)
	public int KadaneAlgo(int[] prices) {
		int maxCur = 0, maxSoFar = 0;

		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}


}
