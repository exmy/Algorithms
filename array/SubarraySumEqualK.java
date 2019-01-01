public class SubarraySumEqualK{
    // Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
    // O(n^2)
    public int subarraySum(int[] a, int k) {
        int[] sum = new int[a.length + 1];
        int ans = 0;
        for(int i = 1; i <= a.length; i++) sum[i] = a[i - 1] + sum[i - 1];
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j <= a.length; j++){
                if(sum[j] - sum[i] == k) ans++;
            }
        }
        return ans;
    }

    public int subarraySum(int[] a, int k) {
        int ans = 0;
        for(int i = 0; i < a.length; i++){
            int sum = 0 ;
            for(int j = i; j < a.length; j++){
                sum += a[j];
                if(sum == k) ans++;
            }
        }
        return ans;
    }

    // O(nlogn)
    public int subarraySum(int[] a, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            if(map.containsKey(sum - k)) ans += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }


}