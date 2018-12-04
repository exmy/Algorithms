public class BasicBitAlgo{
    
    public int NumberOf1(int n) {
        int cnt = 0;
        long flag = 1;
        for(int i = 0; i < 32; i++){
            if((n & flag) != 0) cnt++;
            flag <<= 1;
        }
        return cnt;
    }
    
    public int NumberOfOne(int n){
        int cnt = 0;
        while(n != 0){
            cnt++;
            n &= n - 1;
        }
        return cnt;
    }
}