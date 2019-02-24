class Up2DownMergeSort{

    private int[] aux;

    public void sort(int[] nums){
        int n = nums.length;
        aux = new int[n];

        for(int sz = 1; sz < n; sz += sz){
            for(int lo = 0; lo < n - sz; lo += sz + sz){
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    private void merge(int[] nums, int l, int m, int h){
        int i = l, j = m + 1;
        for(int k = l; k <= h; k++) aux[k] = nums[k];
        for(int k = l; k <= h; k++){
            if(i > m) nums[k] = aux[j++];
            else if(j > h) nums[k] = aux[i++];
            else if(aux[i] <= aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }
}