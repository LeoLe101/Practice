public class LC121BestTimeToBuySellStock {

    /**
     * Space (1)
     * Time (N): 1 time loop
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        int result = 0;

        for (int price : prices) {
            buy = Math.min(buy, price);

            if (buy < price) {
                profit = price - buy;
                result = Math.max(result, profit);
            }
        }
        return result;
    }

}
