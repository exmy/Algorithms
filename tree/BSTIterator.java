public class BSTIterator {

    private LinkedList<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        add(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        add(node.right);
        return node.val;
    }
    
    private void add(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
