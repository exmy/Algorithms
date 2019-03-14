class CombinationSum{

    // leetcode 39 backtracing
    // 每个数可以多次使用
    // Input: candidates = [2,3,6,7], target = 7,
    /*
        A solution set is:
        [
            [7],
            [2,2,3]
        ]
    */

    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(a == null || a.length == 0) return ans;
        
        Arrays.sort(a);
        List<Integer> com = new ArrayList<>();
        dfs(ans, 0, target, com, a);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, int k, int target, List<Integer> com, int[] a){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(com));
            return;
        }
        if(target < a[k]) return;
        for(int i = k; i < a.length; i++){
            if(target < a[i]) return;
            com.add(a[i]);
            dfs(ans, i, target - a[i], com, a);
            com.remove(com.size() - 1);
        }
    }

}