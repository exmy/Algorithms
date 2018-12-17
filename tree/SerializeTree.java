public class SerializeTree{

    public String Serialize(TreeNode root) {
        StringBuilder tree = new StringBuilder();
        serialize(root, tree);
        return tree.toString();
    }
    private void serialize(TreeNode root, StringBuilder tree){
        if(root == null){
            tree.append("+ ");
            return;
        }
        tree.append(root.val + " ");
        serialize(root.left, tree);
        serialize(root.right, tree);
    }

    int i = -1;
    public TreeNode Deserialize(String str) {
        String[] tree = str.split(" ");
        return deserialize(tree);
    }

    private TreeNode deserialize(String[] tree){
        i++;
        if(i >= tree.length || tree[i].equals("+")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tree[i]));
        root.left = deserialize(tree);
        root.right = deserialize(tree);
        return root;
    }
}