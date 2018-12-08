public class MaxiumSum{
    public int findGreatestSumOfSubArray(int[] a) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            if(sum <= 0){
                sum = a[i];
            }else{
                sum += a[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}