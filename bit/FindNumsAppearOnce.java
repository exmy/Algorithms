public class FindNumsAppearOnce{

    // 一个整数数组里除了两个数字外，其他都出现两次，找出这两个只出现一次的数字。

    // 思路：
    // 把原数组分成两个子数组，使得每个子数组只包含一个只出现一次的数字，而其他数字都成对出现两次。

    public void findNumsAppearOnce(int [] a,int num1[] , int num2[]) {
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