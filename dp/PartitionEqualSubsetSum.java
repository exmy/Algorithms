class PartitionEqualSubsetSum{

    // leetcode 416
    // Given a non-empty array containing only positive integers, 
    // find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

    // Input: [1, 5, 11, 5]
    // Output: true
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums) sum += n;
        if(sum % 2 == 1) return false;
        sum /= 2;
        
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; i++) dp[i][0] = true;
        for(int j = 1; j <= sum; j++) dp[0][j] = false;
        
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]) dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
            }
        }
        
        return dp[nums.length][sum];
    }
}