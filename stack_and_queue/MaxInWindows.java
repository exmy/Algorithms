public class MaxInWindows{
     public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Integer> win = new LinkedList<>();

        if(num == null || num.length < size) return ans;
        for(int i = 0; i < size; i++){
            while(!win.isEmpty() && num[i] >= win.peekFirst()) win.removeFirst();
            win.offerLast(num[i]);
        }

        for(int i = size; i < num.length; i++){
            ans.add(win.peek());
            while(!win.isEmpty() && num[i] >= win.peekFirst()) win.removeFirst();
            win.offerLast(num[i]);
            if(win.size() >= size) win.removeFirst();

        }
        ans.add(win.peekFirst());
        return ans;
    }
}