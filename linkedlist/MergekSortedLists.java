class MergekSortedLists{

    // leetcode 23
    // Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode node: lists){
            if(node != null) pq.offer(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null) pq.offer(node.next);
            p.next = node;
            p = p.next;
        }
        return head.next;
    }
    
}