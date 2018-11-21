package linklist;

public class LinkList{

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode p = cur.next;
            cur.next = head;
            head = cur;
            cur = p;
        }
        return head;
    }
    public ListNode recursiveReverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode nhead = recursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nhead;
    }
}