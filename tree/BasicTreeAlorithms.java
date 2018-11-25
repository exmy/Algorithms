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
}