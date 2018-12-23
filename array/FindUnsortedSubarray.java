public class FindUnsortedSubarray{
    
    public int findUnsortedSubarray(int[] a) {
        // 2 6 4 8 10 9 15
        // 2 4 6 8 9 10 15
        int[] b = a.clone();
        Arrays.sort(b);
        int start = b.length, end = 0;
        for(int i = 0; i < b.length; i++){
            if(a[i] != b[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }
}