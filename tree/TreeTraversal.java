class TreeTraversal{


    // 后序遍历
    // way 1
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if(node.left != null)  stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return ans;
    }

    // way 2
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Stack<Integer> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode visited = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.peek();
                if(cur.right != null && cur.right != visited){
                    cur = cur.right;
                }else{
                    ans.add(cur.val);
                    visited = cur;
                    stack.pop();
                    cur = null;
                }
            }
        }
        return ans;
    }


    // way 3
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Stack<Integer> stack = new Stack<>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty){
            if(p != null){
                stack.push(p);
                ans.addFirst(p.val); // Reverse the process of preorder
                p = p.right; // Reverse the process of preorder
            }else{
                TreeNode node = stack.pop();
                p = node.left; // Reverse the process of preorder
            }
        }
        return ans;
    }
}