public class LongestUnivaluePath{

    // leetcode 687
    // Given a binary tree, find the length of the longest path where each node in the path has the same value. 
    // This path may or may not pass through the root.
    
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        sol(root);
        return ans;
    }
    int sol(TreeNode root){
        if(root == null) return 0;
        int left = sol(root.left);
        int right = sol(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if(root.left != null && root.left.val == root.val){
            arrowLeft += left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
    
}