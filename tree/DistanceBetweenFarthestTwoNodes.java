class DistanceBetweenFarthestTwoNodes{

    // 二叉树中最远的两个节点的距离

    // 思路:
    // 如果具有最远距离的两个节点经过了根节点，那么最远的距离就是左边最深的深度加上右边最深的深度之和
    // 如果具有最远距离的两个节点之间的路径不经过根节点，那么最远的距离就在根节点的其中一个子树上的两个叶子结点

    private int ans = -1;
    public int farDistance(TreeNode root){
        height(root);
        return ans;
    }    

    private int height(TreeNode root){
        if(root == null) return 0;
        int left  = height(root.left);
        int right = height(root.right);

        ans = Math.max(ans, left + right);

        return 1 + Math.max(left, right);
    }
}