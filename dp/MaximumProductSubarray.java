class MaximumProductSubarray{

    // leetcode 152
    // Given an integer array nums, 
    // find the contiguous subarray within an array (containing at least one number) which has the largest product.

    // Input: [2,3,-2,4], Output: 6
    // Input: [-2,0,-1], Output: 0

    public int maxProduct(int[] a) {
        int ans = a[0];
        
        // imax/imin stores the max/min product of subarray that ends with the current number A[i]
        for(int i = 1, imax = ans, imin = ans; i < a.length; i++){
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if(a[i] < 0){
                int t = imax;
                imax = imin;
                imin = t;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(a[i], imax * a[i]);
            imin = Math.min(a[i], imin * a[i]);
            
            ans = Math.max(ans, imax);
        }
        return ans;
    }
}