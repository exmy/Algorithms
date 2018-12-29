public class FindAllDuplicates{
    // Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    // Find all the elements that appear twice in this array.
    // [4,3,2,7,8,2,3,1] -> [2,3]
    public List<Integer> findDuplicates(int[] a) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            int index = Math.abs(a[i]) - 1;
            if(a[index] < 0) ans.add(index + 1);
            a[index] = -a[index];
        }
        return ans;
    }
}