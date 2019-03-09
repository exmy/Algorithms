class WordBreak{

    // leetcode 139
    // Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
    // determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    // Input: s = "leetcode", wordDict = ["leet", "code"]
    // Output: true

     public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
     }
}