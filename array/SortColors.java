class SortColors{

    // leetcode 75
    // Given an array with n objects colored red, white or blue, 
    // sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    public void sortColors(int[] a) {
        int r = a.length - 1, l = 0;
        for(int i = 0; i <= r; i++){
            while(a[i] == 2 && i < r) swap(a, i, r--);
            while(a[i] == 0 && i > l) swap(a, i, l++);
        }
    }
    
    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}