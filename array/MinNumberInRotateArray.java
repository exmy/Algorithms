public class MinNumberInRotateArray{

    public int minNumberInRotateArray(int [] a) {
        if(a.length == 0) return 0;
        int l = 0, h = a.length - 1;
        int mid = l;
        while(a[l] >= a[h]){
            if(h - l == 1) {
                mid = h;
                break;
            }
            mid = (l + h) >> 1;
            
            if(a[l] == a[h] && a[l] == a[mid]){
                int ans = a[l];
                for(int i = l + 1; i <= h; i++){
                    if(a[i] < a[i - 1]) return a[i];
                }
            }
            
            if(a[mid] >= a[l]) l = mid;
            else h = mid;
        }
        return a[mid];
    }

}