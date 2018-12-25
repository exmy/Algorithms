public class XXXSum{
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
    // Find all unique triplets in the array which gives the sum of zero.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i + 2 < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while(j < k){
                if(nums[j] + nums[k] == target){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }else if(nums[j] + nums[k] < target) j++;
                else k--;
            }
        }
        return ans;
    }
}