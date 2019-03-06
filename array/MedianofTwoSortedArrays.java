class MedianofTwoSortedArrays{

    // leetcode 4
    // Median of Two Sorted Arrays

    // A[0]...A[i-1] | A[i]...A[m-1]
    // B[0]...B[j-1] | B[j]...B[n-1]
    // 在i...m之间二分查找i，使i满足:
    // i + j == m - i + n - j + 1
    // A[i-1] <= B[j] and B[j-] <= A[i]
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if(m > n){
            int[] t = A;
            A = B;
            B = t;
            m = A.length;
            n = B.length;
        }
        int imin = 0, imax = m, half = (m + n + 1) / 2;
        while(imin <= imax){
            int i = (imin + imax) / 2;
            int j = half - i;
            if(i < m && B[j-1] > A[i]) imin = i + 1;
            else if(i > 0 && A[i-1] > B[j]) imax = i - 1;
            else{
                int maxleft = 0;
                if(i == 0) maxleft = B[j-1];
                else if(j == 0) maxleft = A[i-1];
                else maxleft = Math.max(A[i-1], B[j-1]);
                
                if((m + n) % 2 == 1) return maxleft;
                
                int minright = 0;
                if(i == m) minright = B[j];
                else if(j == n) minright = A[i];
                else minright = Math.min(A[i], B[j]);
                
                return (minright + maxleft) / 2.0;
            }
        }
        return -1;
    }
}