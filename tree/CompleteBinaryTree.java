class CompleteBinaryTree{

    // 利用层遍历。如果当前遍历到了NULL结点，后续还有非NULL结点，说明是非完全二叉树

    public boolean isCompleteBinaryTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return true;
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null) {
                if(flag) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }else flag = true;
        }
        return true;
    }
}