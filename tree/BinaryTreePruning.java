public class BinaryTreePruning{

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }
    boolean containsOne(TreeNode root){
        if(root == null) return false;
        boolean f1 = containsOne(root.left);
        boolean f2 = containsOne(root.right);
        if(!f1) root.left = null;
        if(!f2) root.right = null;
        return root.val == 1 || f1 || f2;
    }

}