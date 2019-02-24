class BestTimetoBuyandSellStock{

    // leetcode 121
    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
    // design an algorithm to find the maximum profit.

    // Input: [7,1,5,3,6,4]
    // Output: 5

    public int maxProfit(int[] p) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < p.length; i++){
            minPrice = Math.min(minPrice, p[i]);
            maxProfit = Math.max(maxProfit, p[i] - minPrice);
        }
        return maxProfit;
    }
}