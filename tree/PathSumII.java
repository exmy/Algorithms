public class PathSumII{

    // leetcode 113
    // Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.


    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        pathSumHelper(root, path, sum);
        return ans;
    }

    void pathSumHelper(TreeNode root, List<Integer> path, int sum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            List<Integer> clone = new ArrayList<>(path);
            clone.add(root.val);
            int tmp = 0;
            for(int i : clone) tmp += i;
            if(tmp == sum) ans.add(clone);
            return;
        }
        path.add(root.val);
        pathSumHelper(root.left, path, sum);
        pathSumHelper(root.right, path, sum);
        path.remove(path.size() - 1);
    }


    // more clean
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