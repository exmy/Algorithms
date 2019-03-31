class DiameterOfBinaryTree{

    // leetcode 543
    // Given a binary tree, you need to compute the length of the diameter of the tree.
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
    // This path may or may not pass through the root.

    // 实际上就是求 二叉树中最远的两个节点的距离
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int t = depth(root);
        return ans;
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        int left  = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}