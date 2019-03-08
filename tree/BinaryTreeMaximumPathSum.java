class BinaryTreeMaximumPathSum{

    // leetcode 124
    // Given a non-empty binary tree, find the maximum path sum.
    // For this problem, 
    // a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
    
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}