public class ReConstructBinaryTree{
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    private TreeNode construct(int[] pre, int prel, int preh, int[] in, int inl, int inh){
        if(prel > preh || inl > inh) return null;
        int i = inl;
        for(; i <= inh && in[i] != pre[prel]; i++);
        TreeNode root = new TreeNode(pre[prel]);
        // (i - inl) means the length of the left subtree
        root.left = construct(pre, prel + 1, prel + i - inl, in, inl, i - 1);
        root.right = construct(pre, prel + i - inl + 1, preh, in, i + 1, inh);
        return root;
    }

    public TreeNode constructTree(int[] pre, int[] in){
        if(pre.length == 0 || in.length == 0) return null;

        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        for(; i < in.length && in[i] != pre[0]; i++);
        root.left = constructTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
        root.right = constructTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(int, i + 1, in.length));
        return root;
    }

}