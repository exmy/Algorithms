public class PathSumII{
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
}