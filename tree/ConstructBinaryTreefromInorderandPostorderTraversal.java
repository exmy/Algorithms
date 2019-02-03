class ConstructBinaryTreefromInorderandPostorderTraversal{

    // Given inorder and postorder traversal of a tree, construct the binary tree.
    public TreeNode buildTree(int[] in, int[] post) {
        if(in == null || post == null || in.length != post.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) map.put(in[i], i);
        return build(in, 0, in.length - 1, post, 0, post.length - 1, map);
    }
    
    private TreeNode build(int[] in, int il, int ir, int[] post, int pl, int pr, Map<Integer, Integer> map){
        if(il > ir || pl > pr) return null;
        TreeNode root = new TreeNode(post[pr]);
        int m = map.get(post[pr]);
        root.left  = build(in, il, m - 1, post, pl, pl + m - il - 1, map);
        root.right = build(in, m + 1, ir, post, pl + m - il, pr - 1, map);
        return root;
    }
}