class SubarraysWithKDifferentIntegers{

    // leetcode 992
    // Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.
    // Return the number of good subarrays of A.

    // Input: A = [1,2,1,2,3], K = 2
    // Output: 7

    public int subarraysWithKDistinct(int[] a, int k) {
        if(a == null || a.length < k) return 0;
        int i = 0, j = 0;
        int ans = 0, cnt = 0, prefix = 0;
        int[] m = new int[a.length + 1];
        while(j < a.length){
            if(m[a[j++]]++ == 0) cnt++;
            if(cnt > k){
                m[a[i++]]--;
                cnt--;
                prefix = 0;
            }
            while(m[a[i]] > 1){
                prefix++;
                m[a[i++]]--;
            }
            if(cnt == k) ans += prefix + 1;
        }
        return ans;
    }
}