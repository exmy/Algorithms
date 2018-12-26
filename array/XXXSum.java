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

    // Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
    // Return the sum of the three integers. You may assume that each input would have exactly one solution.
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dist = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i + 2 < nums.length; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int curSum = nums[i] + nums[j] + nums[k];
                int curDist = Math.abs(target - curSum);
                if(curDist == 0) return curSum;
                if(curDist < dist){
                    dist = curDist;
                    ans = curSum;
                }
                if(curSum < target) j++;
                else k--;
            }
        }
        return ans;
    }

    // Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
    // Find all unique quadruplets in the array which gives the sum of target.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i + 3 < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j + 2 < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                int t = target - nums[i] - nums[j];
                while(l < r){
                    if(nums[l] + nums[r] == t){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l - 1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    }else if(nums[l] + nums[r] < t) l++;
                    else r--;
                }
            }
        }
        return ans;
    }

    // more efficient
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if(nums.length == 0) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int min = nums[0], max = nums[nums.length - 1];
        if(4 * min > target || 4 * max < target) return ans;
        for(int i = 0; i + 3 < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] + 3 * max < target) continue;
            if(4 * nums[i] > target) break;
            if(4 * nums[i] == target){
                if(nums[i + 3] == nums[i]) ans.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                break;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            for(int j = i + 1; j + 2 < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                int t = target - nums[i] - nums[j];
                while(l < r){
                    if(nums[l] + nums[r] == t){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l - 1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    }else if(nums[l] + nums[r] < t) l++;
                    else r--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length-1];
        if (4 * min > target || 4 * max < target) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i < nums.length - 3; i++) {
            int num = nums[i];

            if (i > 0 && num == nums[i-1]) {
                continue;
            }

            if (num + 3 * max < target) {
                continue;
            }

            if (4 * num > target) {
                break;
            }

            if (4 * num == target) {
                if (nums[i+3] == num) {
                    result.add(Arrays.asList(num, num, num, num));
                }
                break;
            }

            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }

            threeSum3(nums, i+1, target - nums[i], nums[i], result);
        }

        return result;
    }

    private void threeSum3(int[] nums, int start, int target, int first, List<List<Integer>> result) {
        int min = nums[start];
        int max = nums[nums.length-1];

        if (3 * min > target || 3 * max < target) {
            return;
        }

        for (int i=start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            if (nums[i] + 2 * max < target) {
                continue;
            }

            if (3 * nums[i] > target) {
                break;
            }

            if (3 * nums[i] == target) {
                if (nums[i+2] == nums[i]) {
                    result.add(Arrays.asList(first, nums[i], nums[i], nums[i]));
                }
                break;
            }

            if (nums[i] + nums[i+1] + nums[i+2] > target) {
                break;
            }

            twoSum3(nums, i+1, target - nums[i], first, nums[i], result);
        }
    }

    private void twoSum3(int[] nums, int start, int target, int first, int second, List<List<Integer>> result) {
        int min = nums[start];
        int max = nums[nums.length-1];

        if (2 * min > target || 2 * max < target) {
            return;
        }

        int left = start, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(first, second, nums[left], nums[right]));

                while (left < right && nums[left] == nums[left+1]) {
                    left++;
                }

                while (left < right && nums[right] == nums[right-1]) {
                    right--;
                }

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    // Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                ans += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }
        return ans;
    }
}