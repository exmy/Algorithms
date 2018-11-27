public class MaximumBinaryTree{

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructBinaryTree(nums, 0, nums.length - 1);
    }
        
    TreeNode constructBinaryTree(int[] nums, int l, int r){
        if(l > r) return null;
        int maxval = nums[l];
        int index = l;
        for(int i = l + 1; i <= r; i++){
            if(nums[i] > maxval){
                maxval = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxval);
        root.left = constructBinaryTree(nums, l, index - 1);
        root.right = constructBinaryTree(nums, index + 1, r);
        return root;
    }

}