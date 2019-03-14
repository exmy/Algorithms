class CoinChange {

    /*
        leetcode 322 
        You are given coins of different denominations and a total amount of money amount. 
        Write a function to compute the fewest number of coins that you need to make up that amount. 
        If that amount of money cannot be made up by any combination of the coins, return -1.

        Input: coins = [1, 2, 5], amount = 11
        Output: 3 
        Explanation: 11 = 5 + 5 + 1
    */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];       
    }

    public int coinChangeDFS(int[] coins, int target, int[] memo){
        if(target < 0) return -1;
        if(target == 0) return 0;
        if(memo[target] != Integer.MAX_VALUE) return memo[target];
        for(int i = 0; i < coins.length; i++){
            int tmp = coinChangeDFS(coins, target - coins[i], memo);
            if(tmp >= 0) memo[target] = Math.min(memo[target], tmp + 1);
        }
        return memo[target] = (memo[target] == Integer.MAX_VALUE) ? -1 : memo[target];
    }
}