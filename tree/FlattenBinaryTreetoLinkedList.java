class FlattenBinaryTreetoLinkedList{

    // leetcode 114
    // Given a binary tree, flatten it to a linked list in-place.

    // 以右左根的顺序后序遍历
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}