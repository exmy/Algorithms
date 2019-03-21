class MonotoneIncreasingDigits{

    // leetcode 738
    // Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

    // Input: N = 1234, Output: 1234
    // Input: N = 6688842, Output: 667999

    public int monotoneIncreasingDigits(int n) {
        if(n < 10) return n;
        char[] s = String.valueOf(n).toCharArray();
        int mark = s.length;
        for(int i = s.length - 1; i > 0; i--){
            if(s[i-1] > s[i]){
                mark = i;
                s[i-1]--;
            }
        }
        for(int i = mark; i < s.length; i++) s[i] = '9';
        return Integer.parseInt(new String(s));
    }
}