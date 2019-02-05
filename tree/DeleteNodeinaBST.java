class DeleteNodeinaBST{

    // Given a root node reference of a BST and a key, delete the node with the given key in the BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key){
             root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.right == null) return root.left;
            // both left and right
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode root){
        while(root.left != null) root = root.left;
        return root;
    }
}