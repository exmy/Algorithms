class HeapSort{

    // a[1...n]
    public void heapSort(int[] a){
        int n = a.length - 1;
        for(int i = n / 2; i >= 1; i--){
            sink(a, i, n);
        }

        while(n > 1){
            swap(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private void sink(int[] a, int k, int n){
        while(2 * k <= n){
            int j = 2 * k;
            if(j < n && a[j] < a[j + 1]) j++;
            if(a[k] >= a[j]) break;
            swap(a, k, j);
            k = j;
        }
    }

    // a[0..n-1]
    public void heapSort(int[] a){
        int n = a.length - 1;
        for(int i = n / 2; i >= 0; i--){
            sink(a, i, n);
        }

        while(n >= 0){
            swap(a, 0, n--);
            sink(a, 0, n);
        }
    }

    private void sink(int[] a, int k, int n){
        while(2 * k + 1<= n){
            int j = 2 * k + 1;
            if(j < n && a[j] < a[j + 1]) j++;
            if(a[k] >= a[j]) break;
            swap(a, k, j);
            k = j;
        }
    }

    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}