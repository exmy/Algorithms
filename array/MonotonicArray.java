public class MonotonicArray{
    public boolean isMonotonic(int[] A) {
        int s = 0;
        for(int i = 0; i < A.length - 1; i++){
            int c = Integer.compare(A[i], A[i+1]);
            if(c != 0){
                if(c != s && s != 0) return false;
                s = c;
            }
        }
        return true;
    }
}