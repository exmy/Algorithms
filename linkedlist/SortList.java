public class SortList{

    // mergesort
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        return merge(sortList(head), sortList(mid));
    }
    
    ListNode findMid(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
    
    ListNode merge(ListNode h1, ListNode h2){
        ListNode nhead = new ListNode(0);
        ListNode p1 = h1, p2 = h2, p = nhead;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 != null) p.next = p1;
        else if(p2 != null) p.next = p2;
        return nhead.next;
    }
    
}