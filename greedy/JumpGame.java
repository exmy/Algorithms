class JumpGame{

    // leetcode 55
    // Given an array of non-negative integers, you are initially positioned at the first index of the array.
    // Each element in the array represents your maximum jump length at that position.
    // Determine if you are able to reach the last index.

    // Input: [2,3,1,1,4]
    // Output: true

    public boolean canJump(int[] a) {
        int reach = a[0];
        for(int i = 1; i < a.length; i++){
            if(reach < i) return false;
            reach = Math.max(reach, i + a[i]);
        }
        return true;
    }
}