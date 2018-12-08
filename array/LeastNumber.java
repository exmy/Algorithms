public class LeastNumber{

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(k > a.length) return ans;
        for(int i = 0; i < a.length; i++) pq.offer(a[i]);
        for(int i = 0; i < k; i++){
            ans.add(pq.poll());
        }
        return ans;
    }
    
}