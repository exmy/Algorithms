class SearchinRotatedSortedArray{
    
    // leetcode 33
    // Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    // You are given a target value to search. If found in the array return its index, otherwise return -1.

    // Input: nums = [4,5,6,7,0,1,2], target = 0
    // Output: 4

    public int search(int[] a, int target) {
        if(a == null || a.length == 0) return -1;
        int l = 0, h = a.length - 1;
        // 先找出最小的那个数的索引
        while(l < h){
            int m = (l + h) >> 1;
            if(a[m] > a[h]) l = m + 1;
            else h = m;
        }
         // 二分搜索
        int rot = l;
        l = 0;
        h = a.length - 1;
        while(l <= h){
            int m = (l + h) >> 1;
            int rm = (m + rot) % a.length;
            if(a[rm] == target) return rm;
            if(a[rm] < target) l = m + 1;
            else h = m - 1;
        }
        
        return -1;
    }
}