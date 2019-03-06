class AddTwoNumbers{

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int sum = 0;

        while(p1 != null || p2 != null){
            sum /= 10;
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if(sum / 10 == 1){
            p.next = new ListNode(1);
        }
        return head.next;
    }
}