class StoneMerge{

    // poj 1738

    private static final int INF = 0x3f3f3f3f;

    // a[1..n] starts from 1, eg. a[] = {0, 3, 4, 3}
    public int stoneMerge(int[] a){
        int n = a.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n];
        n--;

        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + a[i];
        }
        for(int l = 2; l <= n; l++){
            for(int i = 1; i + l - 1 <= n; i++){
                int j = i + l - 1;
                dp[i][j] = 0x3f3f3f3f;
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[j] - sum[i-1]);
                }
            }
        }


        return dp[1][n];
    }
}