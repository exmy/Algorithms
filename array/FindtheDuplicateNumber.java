public class FindtheDuplicateNumber{

    // Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
    // prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
    
    // example
    // input: [1,3,4,2,2]
    // output: 2
    
    // O(nlogn)
    public int findDuplicate(int[] a) {
        int l = 1, r = a.length - 1;
        int cnt = 0;
        while(l < r){
            int m = (l + r) >> 1;
            cnt = 0;
            for(int i: a) if(i <= m) cnt++;
            if(cnt <= m) l = m + 1;
            else r = m;
        }
        return l;
    }

    // O(n)
    public int findDuplicate(int[] a) {
        int slow = a[0], fast = a[a[0]];
        while(slow != fast){
            slow = a[slow];
            fast = a[a[fast]];
        }
        
        fast = 0;
        while(fast != slow){
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}