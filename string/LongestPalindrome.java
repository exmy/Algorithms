class LongestPalindrome{

    // Given a string s, find the longest palindromic substring in s.

    private int len, lo;
    
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;
        
        for(int i = 0; i < n - 1; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        
        return s.substring(lo, lo + len);
    }
    
    private void extendPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(len < j - i - 1){
            len = j - i - 1;
            lo = i + 1;
        }
    }
}