class CountCompleteTreeNodes{
    
    // Given a complete binary tree, count the number of nodes.
    public int countNodes(TreeNode root) {
        int l = 0, r = 0;
        TreeNode left = root, right = root;
        while(left != null){
            l++;
            left = left.left;
        }
        while(right != null){
            r++;
            right = right.right;
        }
        if(l == r) return (int)Math.pow(2, l) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right); 
    }
}