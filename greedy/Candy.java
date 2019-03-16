class Candy{

    // leetcode 135
    // There are N children standing in a line. Each child is assigned a rating value.
    // You are giving candies to these children subjected to the following requirements:

    // Each child must have at least one candy.
    // Children with a higher rating get more candies than their neighbors.
    // What is the minimum candies you must give?

    // Input: [1,0,2]
    // Output: 5

    public int candy(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        Arrays.fill(b, 1);
        for(int i = 1; i < n; i++){
            if(a[i] > a[i-1]) b[i] = b[i-1] + 1;
        }
        for(int i = n - 2; i >= 0; i--){
            if(a[i] > a[i+1]) b[i] = Math.max(b[i], b[i+1]+1);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) ans += b[i];
        return ans;
    }
}