public class PartitionList{

    // leetcode 86
    // Given a linked list and a value x, 
    // partition it such that all nodes less than x come before nodes greater than or equal to x.

    // Input: head = 1->4->3->2->5->2, x = 3
    // Output: 1->2->2->4->3->5

    
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