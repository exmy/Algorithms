public class PartitionList{
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode great = new ListNode(-1);
        ListNode p1 = less, p2 = great;
        while(head != null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else{
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = great.next;
        return less.next;
    }
}