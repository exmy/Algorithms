public BSTConvertDoubleLinkedList {
    TreeNode head = null;
    TreeNode pre = null;
    public TreeNode convert(TreeNode root) {
        TreeNode pre = null;
        inorder(root);
        return head;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre == null) head = root;
        root.left = pre;
        if(pre != null){
            pre.right = root;
        }
        pre = root;
        inorder(root.right);
    }
}