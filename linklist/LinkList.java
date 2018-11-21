package linklist;

public class LinkList{

    // reverse a singly linked list
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

    // merge two sorted lists
    public ListNode recursiveMergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = recursiveMergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = recursiveMergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return head.next;
    }

    // determine if a linked list has a cycle in it
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}