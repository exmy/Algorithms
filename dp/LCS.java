class LCS {

    // 给定两个序列X=<x1,x2,...,xm>和Y=<y1,y2,...,yn>，求X和Y的最长公共子序列
    public int lcs(char[] s1, char[] s2){
        int[][] dp = new int[s1.length+1][s2.length+1];

        for(int i = 1; i <= s1.length; i++){
            for(int j = 1; j < s2.length; j++){
                if(s1[i] == s2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[s1.length][s2.length];
    }

    private void print(int[][] dp, char[] s1, char[] s2, int i, int j){
        if(i == 0 || j == 0) return;
        if(s1[i-1] == s2[j-1]){
            System.out.print(s1[i-1]);
            print(dp, s1, s2, i-1, j-1);
        }else if(dp[i-1][j] >= dp[i][j-1]) print(dp, s1, s2, i-1, j);
        else print(dp, s1, s2, i, j-1);
    }

    // 最长公共子串
    public int lcsString(char[] s1, char[] s2){
        int[][] dp = new int[s1.length+1][s2.length+1];

        int maxlen = 0;
        int maxindex = 0;
        for(int i = 1; i <= s1.length; i++){
            for(int j = 1; j < s2.length; j++){
                if(s1[i] == s2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] > maxlen){
                        maxlen = dp[i][j];
                        maxindex = i + 1 - maxlen;
                    }
                }
            }
        }
        return maxlen;
    }

    // 最长递增子序列
    public int LIS(char[] s){
        int n = s.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(s[i] > s[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


}