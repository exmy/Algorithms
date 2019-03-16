class DecodeWays{

    // leetcode 91
    // A message containing letters from A-Z is being encoded to numbers using the following mapping:
    // 'A' -> 1, 'B' -> 2 ... 'Z' -> 26
    // Input: "12"
    // Output: 2

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++){
            int a = Integer.parseInt(s.charAt(i-1) + "");
            int b = Integer.parseInt(s.charAt(i-2) + "" + s.charAt(i-1));
            if(a >= 1 && a <= 9) dp[i] += dp[i-1];
            if(b >= 10 && b <= 26) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}