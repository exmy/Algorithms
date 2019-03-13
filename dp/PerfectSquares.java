class PerfectSquares{

    // leetcode 279
    // Given a positive integer n, 
    // find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

    // Input: n = 12
    // Output: 3 
    // Explanation: 12 = 4 + 4 + 4.
    
    public int numSquares(int n) {
        if(n < 1) return 0;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}