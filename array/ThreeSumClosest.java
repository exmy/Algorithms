package com.company;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = target - nums[0] - nums[1] - nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int newTarget = target - nums[i];
            while (start < end) {
                if (nums[start] + nums[end] == newTarget) return target;
                int diff = newTarget - (nums[start] + nums[end]);
                if (Math.abs(diff) < Math.abs(closest)) closest = diff;
                if (nums[start] + nums[end] < newTarget) start++;
                else end--;
            }
        }
        return target - closest;
    }
}
