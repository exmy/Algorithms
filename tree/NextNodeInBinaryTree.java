public class NextNodeInBinaryTree{

    /*
    * 考虑三种情况：
        1. node 右子树不为空，那next即为右子树中的最左节点
        2. node 右子树为空且node为其父节点的左节点，那next即为其父节点
        3. node 右子树为空且node为其父节点的右节点，那沿着父节点一直往上遍历，直到找到一个节点，这个节点是其父节点的左节点
           next即为这个节点的父节点
    */
    public TreeLinkNode getNext(TreeLinkNode node){
        if(node == null) return null;
        TreeLinkNode next = null;
        if(node.right != null){
            next = node.right;
            while(next.left != null){
                next = next.left;
            }
        }else if(node.parent != null){
            TreeLinkNode parent = node.parent;
            if(parent.left == node) next = parent;
            else{
                while(parent != null && node == parent.right){
                    node = parent;
                    parent = parent.parent;
                }
                next = parent;
            }
        }
        return next;
    }
}