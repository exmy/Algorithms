class RotateList{

    // leetcode 61
    // Given a linked list, rotate the list to the right by k places, where k is non-negative.

    // Input: 1->2->3->4->5->NULL, k = 2
    // Output: 4->5->1->2->3->NULL

    // 思路：

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode tail = head;
        int n = 1;
        while(tail.next != null){
            n++;
            tail = tail.next;
        }
        tail.next = head;
        k %= n;
        if(k > 0){
            for(int i = 0; i < n - k; i++) tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        
        return head;
    }
}