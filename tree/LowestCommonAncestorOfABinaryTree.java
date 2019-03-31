class LowestCommonAncestorOfABinaryTree{

    // leetcode 236
    
    // 1. 如果两个节点分别在根节点的左子树和右子树，则返回根节点
    // 2. 如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    // 如果是BST
    // 左子树 < 根节点 < 右子树
    public TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val) return lcaBST(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return lcaBST(root.right, p, q);
        return root;
    }
}