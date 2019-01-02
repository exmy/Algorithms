public class SumofSubarrayMinimums{

    // Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
    public int sumSubarrayMins(int[] A) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
            left[i] = i + 1;
            right[i] = A.length - i;
        }
        
        // 单调栈
        for(int i = 0; i < A.length; i++){
            while(!s1.isEmpty() && A[s1.peek()] > A[i]){
                s1.pop();
            }
            left[i] = s1.isEmpty() ? i + 1 : i - s1.peek();
            s1.push(i);
            
            while(!s2.isEmpty() && A[s2.peek()] > A[i]){
                right[s2.peek()] = i - s2.peek();
                s2.pop();
            }
            s2.push(i);
        }
        
        int ans = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < A.length; i++){
            ans = (ans + A[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }
}