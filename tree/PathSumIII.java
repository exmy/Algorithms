public class PathSumIII{

    // leetcode 437
    // Find the number of paths that sum to a given value.
    // The path does not need to start or end at the root or a leaf, 
    // but it must go downwards (traveling only from parent nodes to child nodes).

    public int pathSum(TreeNode root, int sum) {
        return root == null ? 0 : f(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    int f(TreeNode root, int sum){
        return root == null ? 0 : (root.val == sum ? 1 : 0) + f(root.left, sum - root.val) + f(root.right, sum - root.val);
    }
    
    int ans = 0;
    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(map, root, 0, sum);
        return ans;
    }
    void dfs(Map<Integer, Integer> map, TreeNode root, int curSum, int sum){
        if(root == null) return;
        curSum += root.val;
        ans += map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(map, root.left, curSum, sum);
        dfs(map, root.right, curSum, sum);
        map.put(curSum, map.get(curSum) - 1);
    }
    
}