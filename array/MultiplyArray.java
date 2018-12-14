public class MultiplyArray{

    public int[] multiply(int[] A) {
        int[] a = A.clone(), b = A.clone();
        int n = A.length;
        
        a[0] = 1;
        for(int i = 1; i < n; i++){
            a[i] = a[i - 1] * A[i - 1];
        }
        b[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            b[i] = b[i + 1] * A[i + 1];
        }
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = a[i] * b[i];
        }
        return ans;
    }
    
}