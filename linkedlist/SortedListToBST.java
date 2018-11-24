public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode mid = findMidListNode(head);
        TreeNode root = new TreeNode(mid.val);
        if(mid == head) return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    
    private ListNode findMidListNode(ListNode head){
        ListNode prevSlow = null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prevSlow != null) prevSlow.next = null;
        return slow;
    }
    
    ListNode head;
    public TreeNode sortedListToBST2(ListNode head) {
        this.head = head;
        int size = listSize(head);
        return convertListToBST(0, size - 1);
    }
    private TreeNode convertListToBST(int l, int r){
        if(l > r) return null;
        int mid = (l + r) >> 1;
        TreeNode left = convertListToBST(l, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = convertListToBST(mid + 1, r);
        return root;
    }
    
    private int listSize(ListNode head){
        ListNode slow = head, fast = head;
        int c = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            c++;
        }
        return (c << 1) + (fast != null ? 1 : 0);
    }
    
}