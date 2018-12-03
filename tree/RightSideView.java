public class RightSideView{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 1, ans);
        return ans;
    }
    
    void dfs(TreeNode root, int depth, List<Integer> ans){
        if(root == null) return;
        if(depth > ans.size()) ans.add(root.val);
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }

    public List<Integer> sol(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> depthQueue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        depthQueue.add(0);
        int maxDepth = -1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer depth = depthQueue.poll();
            if(node != null){
                maxDepth = Math.max(depth, maxDepth);
                if(!map.containsKey(maxDepth)) {
                    map.put(maxDepth, node.val);
                    ans.add(node.val);
                }
                queue.offer(node.right);
                queue.offer(node.left);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }
        return ans;
    }
}