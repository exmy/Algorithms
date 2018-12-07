public class FindPath{

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        ArrayList<Integer> path = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, target, path);
        return ans;
    }
    
    private void dfs(TreeNode root, int target, ArrayList<Integer> path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(target == root.val){
                ArrayList<Integer> tmp = new ArrayList<>(path);
                tmp.add(root.val);
                ans.add(tmp);
            }
            return;
        }
        path.add(root.val);
        dfs(root.left, target - root.val, path);
        dfs(root.right, target - root.val, path);
        path.remove(path.size() - 1);
    }
}