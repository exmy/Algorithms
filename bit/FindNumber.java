public class FindNumber{

    public void FindNumsAppearOnce(int [] a,int num1[] , int num2[]) {
        if(a == null || a.length < 2) return;
        int p = 0;
        for(int i: a) p ^= i;
        int idx = 0;
        while(( p & 1) == 0 && idx < 32){
            p >>= 1;
            idx++;
        }
        for(int i: a){
            if(((i >> idx) & 1) == 0) num1[0] ^= i;
            else num2[0] ^= i;
        }
        
    }
    
}