public class BSTConvertDoubleLinkedList {

    // BST 转换为 双向链表
    // left指针前一个节点，right指向后一个节点

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