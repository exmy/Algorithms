class PopulatingNextRightPointersinEachNode{

    // a perfect binary tree
    // Populate each next pointer to point to its next right node. 
    // If there is no next right node, the next pointer should be set to NULL.
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left != null){
            cur = pre;
            while(cur != null){
                cur.left.next = cur.right;
                if(cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}