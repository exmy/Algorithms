public class KthSmallestOfBST{

    int cnt = 0, ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        findKth(root, k);
        return ans;
    }
    
    // 找到节点后不在遍历
    boolean findKth(TreeNode root, int k){
        if(root == null) return false;
        if(findKth(root.left, k)) return true;
        if(++cnt == k){
            ans = root.val;
            return true;
        }
        if(findKth(root.right, k)) return true;
        return false;
    }
    
    int inorder(TreeNode root, int k){
        LinkedList<TreeNode> stack = new LinkedList<>();
        int i = 0;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                if(++i == k) return root.val;
                root = root.right;
            }
        }
        return -1;
    }

}