public class InversePair{
    private int ans = 0;
    public int InversePairs(int [] a) {
        int[] tmp = new int[a.length];
        ans = 0;
        mergeSort(a, tmp, 0, a.length - 1);
        return ans;
    }
    private void mergeSort(int[] a, int[] tmp, int l, int h){
        if(l < h){
            int m = (l + h) >> 1;
            mergeSort(a, tmp, l, m);
            mergeSort(a, tmp, m + 1, h);
            merge(a, tmp, l, m, h);
        }
    }
    
    private void merge(int[] a, int[] tmp, int l, int m, int h){
        int i = l, j = m + 1;
        int k = l;
        while(i <= m && j <= h){
            if(a[i] <= a[j]) tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                ans += m - i + 1;
                ans %= 1000000007;
            }
        }
        while(i <= m) tmp[k++] = a[i++];
        while(j <= h) tmp[k++] = a[j++];
        
        for(k = l; k <= h; k++) a[k] = tmp[k];
    }
}