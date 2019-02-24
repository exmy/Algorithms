public class SumofSubarrayMinimums{

    // Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

    // input: [3,1,2,4]
    // output: 17

    // Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
    // Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.

    
    // solution:
    // For A[i],assuming there are L numbers that are greater than A[i] in range A[0] ~ A[i – 1], 
    // and there are R numbers that are greater or equal than A[i] in the range of A[i+1] ~ A[n – 1].
    // Thus A[i] will be the min of (L + 1) * (R + 1) subsequences
    public int sumSubarrayMins(int[] A) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
            left[i] = i + 1;
            right[i] = A.length - i;
        }
        // Maintain Stack of Minimums
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