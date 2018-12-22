public class FindAllNumberDisappeared{
    public List<Integer> findDisappearedNumbers(int[] a) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            int val = Math.abs(a[i]) - 1;
            if(a[val] > 0){
                a[val] = -a[val];
            }
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}