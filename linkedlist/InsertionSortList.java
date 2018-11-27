public class InsertionSortList{
    
    public ListNode insertionSortList(ListNode head) {
        if(head  == null || head.next == null) return head;
        ListNode nhead = new ListNode(-1);
        nhead.next = head;
        ListNode p = head.next;
        head.next = null;
        
        while(p != null){
            ListNode pre = nhead;
            ListNode tmp = p.next;
            while(pre.next != null && pre.next.val < p.val) pre = pre.next;
            p.next = pre.next;
            pre.next = p;
            p = tmp;
        }
        
        return nhead.next;
    }
}