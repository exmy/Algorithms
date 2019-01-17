class NextPermutation{

    /*
        从右往左找到第一对 a[i+1]>a[i]的a[i]，然后从右往左找到第一个a[j] > a[i]的a[j]
        swap(a[i], a[j])，然后reverse(a[i+1...])
    */
    public void nextPermutation(int[] a) {
        int n = a.length, i = n - 2, j = n - 1;
        while(i >= 0 && a[i] >= a[i + 1]) --i;
        if(i >= 0){
            while(a[j] <= a[i]) --j;
            swap(a, i, j);
        }
        for(int x = i + 1, y = n - 1; x < y; x++, y--){
            swap(a, x, y);
        }
    }
    
    void swap(int[] a, int i, int j){
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}