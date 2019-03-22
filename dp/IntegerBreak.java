class IntegerBreak{

    // leetcode 343
    // Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
    // Return the maximum product you can get.

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[n];
    }
}