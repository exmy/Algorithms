class MinimumWindowSubstring{

    // leetcode 76
    // Given a string S and a string T, 
    // find the minimum window in S which will contain all the characters in T in complexity O(n).

    
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c: t.toCharArray()) map[c]++;
        int i = 0, j = 0, begin = 0, d = Integer.MAX_VALUE;
        int cnt = t.length();
        while(j < s.length()){
            if(map[s.charAt(j++)]-- > 0) cnt--;
            while(cnt == 0){
                if(j - i < d) d = j - (begin = i);
                if(map[s.charAt(i++)]++ == 0) cnt++;
            }
        }
        return d == Integer.MAX_VALUE ?  "" : s.substring(begin, begin + d);
    }
}