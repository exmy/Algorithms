package linkedlist;

public class BasicLinkedListAlgo{

    // 1. reverse a singly linked list
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

    // 2. merge two sorted lists
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

    // 3. determine if a linked list has a cycle in it
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

    // 4. 链表中环的入口节点
    // 首先判断是否有环，计算环的长度n，fast指针先走n步，然后fast和slow同步移动
    public ListNode entryNodeOfLoop(ListNode head)
    {
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        int n = 1;
        ListNode p = slow.next;
        while(p != slow){
            n++;
            p = p.next;
        }
        
        slow = head;
        fast = head;
        while(n-- > 0){
            fast = fast.next;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 5. 删除有序链表中重复节点, 保留重复节点
    // 1->2->3->3->4->4->5, 删除后1->2->3->4->5
    public ListNode deleteDuplication(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = head;
        while(p.next != null){
            ListNode t = p.next;
            while(t != null && p.val == t.val) t = t.next;
            p.next = t;
            p = p.next;
        }
        return head;
    }

    // 6. 删除有序链表中重复节点, 不保留重复节点
    // 1->2->3->3->4->4->5, 删除后1->2->5
    public ListNode deleteDuplication2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode nhead = new ListNode(0);
        nhead.next = head;
        ListNode p = nhead;
        while(p.next != null){
            ListNode t = p.next;
            boolean mod = false;
            while(t.next != null && t.val == t.next.val){
                t = t.next;
                mod = true;
            }
            p.next = mod ? t.next : t;
            p = mod ? p : p.next;
        }
        return nhead.next;
    }

    // 7. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode nhead = new ListNode(0);
        nhead.next = head;
        ListNode p = nhead.next, prev = nhead;
        while(p != null){
            if(p.val == val) {
                prev.next = p.next;
            }else{
                prev = prev.next;
            }
            p = p.next;
        }
        return nhead.next;
    }
    public ListNode recursiveRemoveElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = recursiveRemoveElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 8. determine if a singly linked list is a palindrome.
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while(p != null){
            stack.offer(p);
            p = p.next;
        }
        p = head;
        while(stack.size() != 0){
            if(stack.peekLast().val != p.val) return false;
            stack.pollLast();
            p = p.next;
        }
        return true;
    }

    ListNode ref;
    public boolean isPalindrome2(ListNode head) {
        ref = head;        
        return check(head);
    }
    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false; 
        ref = ref.next;
        return ans && isEqual;
    }

    // 9. find the node at which the intersection of two singly linked lists begins.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // 10. (k - 1)
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) return null;
        ListNode p = head;
        for(int i = 0; i < k - 1; i++){
            if(p.next != null) p = p.next;
            else return null;
        }
        ListNode q = head;
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}