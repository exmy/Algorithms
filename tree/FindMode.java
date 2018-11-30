public class FindMode{
    List<Integer> list = new ArrayList<>();
    Integer pre = null;
    int cnt = 1, max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        inorder(root);
        int[] a = new int[list.size()];
        for(int i = 0; i < list.size(); i++) a[i] = list.get(i);
        return a;
    }
    
    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre != null){
            if(pre == root.val) cnt++;
            else cnt = 1;
        }
        if(cnt > max){
            max = cnt;
            list.clear();
            list.add(root.val);
        }else if(cnt == max) list.add(root.val);
        pre = root.val;
        inorder(root.right);
    }
}