public class ContinuousSequenceEqualS{
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       int i = 1, j = 2;
       int tmp = 3;
       while(j > i){
           // int tmp = (i + j) * (j - i + 1) / 2;
           if(tmp < sum) tmp += ++j;
           else if(tmp > sum) tmp -= i++;
           else{
               ArrayList<Integer> p = new ArrayList<>();
               for(int k = i; k <= j; k++) p.add(k);
               ans.add(p);
               tmp -= i++;
           }
       }
       return ans;
    }
}