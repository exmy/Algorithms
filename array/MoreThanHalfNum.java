public class MoreThanHalfNum{

    public int MoreThanHalfNum_Solution(int [] a) {
        if(a == null || a.length == 0) return 0;
        int val = a[0], cnt = 1;
        for(int i = 1; i < a.length; i++){
            if(val == a[i]) cnt++;
            else{
                if(--cnt == 0){
                    cnt = 1;
                    val = a[i];
                }
            }
        }
        cnt = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == val) cnt++;
        }
        return cnt > a.length / 2 ? val : 0;
    }

}