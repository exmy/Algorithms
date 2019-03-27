class LongestConsecutiveSequence{

    // leetcode 128 
    // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    // Input: [100, 4, 200, 1, 3, 2], Output: 4
    // Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    // way 1
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            if(!map.containsKey(n)){
                int left  = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                
                int sum = left + right + 1;
                map.put(n, sum);
                
                ans = Math.max(ans, sum);
                
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return ans;
    }

    // way 2
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        for(int x: set){
            if(!set.contains(x-1)){
                int y = x + 1;
                while(set.contains(y)) y++;
                ans = Math.max(ans, y - x);
            }
        }
        return ans;
    }
}