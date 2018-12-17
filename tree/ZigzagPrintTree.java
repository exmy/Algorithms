public class ZigzagPrintTree{

    // 两个栈，分别存奇数层和偶数层节点
    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> s1 = new LinkedList<>();
        LinkedList<TreeNode> s2 = new LinkedList<>();
        s1.push(root);
        int level = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            int n = (level % 2 == 0) ? s1.size() : s2.size();
            LinkedList<TreeNode> s = (level % 2 == 0) ? s1 : s2;
            LinkedList<TreeNode> t = (level % 2 == 0) ? s2 : s1;
            for(int i = 0; i < n; i++){
                TreeNode node = s.pop();
                tmp.add(node.val);
                if(level % 2 == 0){
                    if(node.left != null) t.push(node.left);
                    if(node.right != null) t.push(node.right);
                }else{
                    if(node.right != null) t.push(node.right);
                    if(node.left != null) t.push(node.left);
                }
            }
            level++;
            ans.add(tmp);
        }
        return ans;
    }

}