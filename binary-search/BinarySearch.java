public class BinarySearch{

    
    // 在[l, h)找第一个大于等于k的index
    // e.g. [1,2,3,3,3,3,4], 3, return 2
    public int lowerBound(int[] a, int k){
        int len = a.length;
        int l = 0, m, half;
        while (len > 0){
            half = len >> 1;
            m = l + half;
            if(a[m] < k){
                l = m + 1;
                len = len - half - 1;
            }else {
                len = half;
            }
        }
        return l;
    }

    // 在[l, h)中找第一个大于k的index
    public int upperBound(int[] a, int k){
        int len = a.length;
        int l = 0, half = 0, m = 0;
        while (len > 0){
            half = len >> 1;
            m = l + half;
            if(a[m] > k){
                len = half;
            }else{
                l = m + 1;
                len = len - half - 1;
            }
        }
        return l;
    }

}