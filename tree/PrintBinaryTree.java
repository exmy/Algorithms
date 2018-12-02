public class PrintBinaryTree{

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        String[][] res = new String[h][(1 << h) - 1];
        for(String[] t: res) Arrays.fill(t, "");
        fill(res, root, 0, 0, res[0].length);
        List<List<String>> ans = new ArrayList<>();
        for(String[] t: res) ans.add(Arrays.asList(t));
        return ans;
    }
    
    void fill(String[][] res, TreeNode root, int i, int l, int r){
        if(root == null) return;
        int mid = (l + r) >> 1;
        res[i][mid] = "" + root.val;
        fill(res, root.left, i + 1, l, mid - 1);
        fill(res, root.right, i + 1, mid + 1, r);
    }
    
    int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}