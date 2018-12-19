public class MaxInWindows{
     public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Integer> win = new LinkedList<>();

        if(num == null || size == 0 || num.length < size) return ans;
        for(int i = 0; i < size; i++){
            while(!win.isEmpty() && num[i] >= num[win.peekLast()]) win.removeLast();
            win.offerLast(i);
        }

        for(int i = size; i < num.length; i++){
            ans.add(num[win.peek()]);
            while(!win.isEmpty() && num[i] >= num[win.peekLast()]) win.removeLast();
            win.offerLast(i);
            if(i - win.peekFirst() + 1 > size) win.removeFirst();
        }
        ans.add(num[win.peekFirst()]);
        return ans;
    }

    public ArrayList<Integer> maxInWindows1(int [] a, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < a.length; i++){
            while (!q.isEmpty() && a[i] >= a[q.peekLast()])  q.removeLast();
            while(!q.isEmpty() && i - q.peekFirst() + 1 > k) q.removeFirst();
            q.offerLast(i);
            if(k != 0 && i + 1 >= k) ans.add(a[q.peekFirst()]);
        }
        return ans;
    }
}