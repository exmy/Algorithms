public class BalancedTree{

    public boolean IsBalancedTree(TreeNode root) {
        return isBalance(root) != -1;
    }
    
    private int isBalance(TreeNode root){
        if(root == null) return 0;
        int left = isBalance(root.left);
        if(left == -1) return -1;
        int right = isBalance(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

}