class ReverseLinkedListII{

    // leetcode 92
    // Reverse a linked list from position m to n. Do it in one-pass.

    // Input: 1->2->3->4->5->NULL, m = 2, n = 4
    // Output: 1->4->3->2->5->NULL

    // way 1
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode nhead = new ListNode(-1);
        nhead.next = head;
        ListNode s = null, e = null, p = nhead;
        int i = 0;
        while(p != null){
            if(i == m - 1) s = p;
            if(i == n) e = p;
            i++;
            p = p.next;
        }
        ListNode next = e.next;
        e.next = null;
        s.next = reverse(s.next);
        p = s.next;
        while(p.next != null) p = p.next;
        p.next = next;
        return nhead.next;
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode nhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nhead;
    }

    // way 2
     public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m <= 1) {
            return reverseN(head, n - m + 1);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }    

}