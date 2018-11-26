public class BasicTreeAlgorithms{

    // 1. Given a n-ary tree, find its maximum depth.
     public int maxDepth(Node root) {
        if(root == null) return 0;
        int sub = 0;
        for(int i = 0; i < root.children.size(); i++){
            sub = Math.max(sub, maxDepth(root.children.get(i)));
        }
        return sub + 1;
    }

    // 2. Given a binary search tree and the lowest and highest boundaries as L and R, 
    // trim the tree so that all its elements lies in [L, R]
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return root;
        if(root.val > R) return trimBST(root.left, L, R);
        if(root.val < L) return trimBST(root.right, L, R);
        
        root.left  = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    // 3. Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    // 4.Invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

    // 5. Binary Tree Paths
     public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        construct_paths(root, "", paths);
        return paths;
    }
    void construct_paths(TreeNode root, String path, List<String> paths){
        if(root == null) return;
        path += Integer.toString(root.val);
        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }
        path += "->";
        construct_paths(root.left, path, paths);
        construct_paths(root.right, path, paths);
    }
}