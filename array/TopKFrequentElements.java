class TopKFrequentElements{

    // Given a non-empty array of integers, return the k most frequent elements.
    // Input: nums = [1,1,1,2,2,3], k = 2
    // Output: [1,2]

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int i: map.keySet()){
            pq.offer(i);
            if(pq.size() > k) pq.poll();
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}