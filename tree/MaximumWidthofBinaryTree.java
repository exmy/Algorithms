class MaximumWidthofBinaryTree{
    
    // Given a binary tree, write a function to get the maximum width of the given tree. 

    // dfs
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 1);
        return ans;
    }
    
    private void dfs(TreeNode root, int depth, int pos){
        if(root == null) return;
        map.computeIfAbsent(depth, x -> pos);
        ans = Math.max(ans, pos - map.get(depth) + 1);
        
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }

}