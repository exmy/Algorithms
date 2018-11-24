public class SplitListToParts{

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        int size = getSize(root);
        ListNode p = root;
        List<ListNode> ans = new ArrayList<>();
        if(size <= k){
            while(p != null || k > 0){
                ans.add(p);
                ListNode pre = p;
                if(p != null){
                    p = p.next;
                    pre.next = null;
                }
                k--;
            }
        }else{
            int n = size / k, mod = size % k;
            int cnt = 1;
            ans.add(p);
            while(p != null){
                if(cnt == n){
                    if(mod > 0) {
                        p = p.next;
                        mod--;
                    }
                    ListNode next = p.next;
                    p.next = null;
                    p = next;
                    if(p != null) ans.add(p);
                    cnt = 1;
                    
                }else{
                    p = p.next;
                    cnt++;
                }
            }
        }
        return ans.toArray(new ListNode[ans.size()]);
    }
    
    private int getSize(ListNode head){
        ListNode slow = head, fast = head;
        int c = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            c++;
        }
        return (c << 1) + (fast != null ? 1 : 0);
    }
}