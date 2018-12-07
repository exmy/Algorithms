public class VerifySquenceOfBST{

    public boolean verifySquenceOfBST(int [] s) {
        if(s == null || s.length == 0) return false;
        return verify(s, s.length);
    }
    
    private boolean verify(int[] s, int n){
        if(n == 0) return true;
        int root = s[n - 1];
        int i = 0;
        for(; i < n - 1; i++){
            if(s[i] > root) break;
        }
        int j = i;
        for(; j < n - 1; j++){
            if(s[j] < root) return false;
        }
        return verify(s, i) && verify(s, n - i - 1);
    }
}