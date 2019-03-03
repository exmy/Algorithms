class KthLargestElementinanArray{

    // Find the kth largest element in an unsorted array. 
    // Note that it is the kth largest element in the sorted order, not the kth distinct element.

    // Input: [3,2,1,5,6,4] and k = 2
    // Output: 5

    public int findKthLargest(int[] nums, int k) {
        // 小顶堆，每次poll都删除最小的数，留下的就是最大的数
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : nums){
            pq.offer(a);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    // 快速选择
    // 迭代
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int l = 0, r = nums.length - 1;
        while(l < r){
            int j = partition(nums, l, r);
            System.out.println(j);
            if(j == k) break;
            else if(j < k) l = j + 1;
            else r = j - 1;
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int r){
        int i = l, j = r + 1;
        while(true){
            while(i < r && a[++i] < a[l]);
            while(j > l && a[l] < a[--j]);
            if(i >= j) break;
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;

        /*
            int i = l, j = r;
            while(i < j){
                while(i < j && a[j] >= a[l]) j--;
                while(i < j && a[i] <= a[l]) i++;
                swap(a, i, j);
            }
            swap(a, l, j);
            return j;
        */
    }

    // 递归版本
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        int p = quickSelect(a, 0, n - 1, n - k + 1);
        return a[p];
    }

    private int quickSelect(int[] a, int l, int r, int k){
        int i = l, int j = r, pivot = a[r];
        while(i < j){
            if(a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, r);
        int m = i - l + 1;
        if(m == k) return i;
        else if(m > k) return quickSelect(a, l, i - 1, k);
        else return quickSelect(a, i + 1, r, k - m);
    }

    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void shuffle(int[] a){
        Random random = new Random();
        for(int i = 1; i < a.length; i++){
            int r = random.nextInt(i + 1);
            swap(a, i, r);
        }
    }
    
}