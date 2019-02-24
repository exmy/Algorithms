class TrappingRainWater{

    // leetcode 42
    // Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    // compute how much water it is able to trap after raining.

    // Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    // Output: 6

    // 思路：
    // R[i]记录从右到左的峰值
    // L[i]maxL记录从左到右的峰值
    // h[i]处的水面高为min(L[i], R[i])

    public int trap(int[] h) {
        if(h == null || h.length < 2) return 0;
        int[] R = new int[h.length];
        int maxR = 0;
        for(int i = h.length - 1; i >= 0; i--){
            if(h[i] > maxR) R[i] = maxR = h[i];
            else R[i] = maxR;
        }
        int ans = 0;
        int maxL = h[0];
        for(int i = 1; i < h.length - 1; i++){
            if(h[i] > maxL) maxL = h[i];
            ans += Math.max(Math.min(maxL, R[i]) - h[i], 0);
        }
        return ans;
    }
}