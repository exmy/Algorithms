class FindFirstandLastPositionofElementinSortedArray{

    // leetcode 34
    // Given an array of integers nums sorted in ascending order, 
    // find the starting and ending position of a given target value.

    // Input: nums = [5,7,7,8,8,10], target = 8
    // Output: [3,4]

    public int[] searchRange(int[] A, int target) {
        int i = 0, j = A.length - 1;
        int[] ans = new int[]{-1, -1};
        if(A.length == 0) return ans;
        while(i < j){
            int m = (i + j) / 2;
            if(A[m] < target) i = m + 1;
            else j = m;
        }
        if(A[i] != target) return ans;
        ans[0] = i;
        
        j = A.length - 1;
        while(i < j){
            int m = (i + j) / 2 + 1;
            if(A[m] > target) j = m - 1;
            else i = m;
        }
        ans[1] = j;
        return ans;
    }
}