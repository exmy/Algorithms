class MaximalSquare{

    // leetcode 221
    // Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    /*
        Input: 

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        Output: 4
    */

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans * ans;
    }
}