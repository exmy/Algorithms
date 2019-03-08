public class RegMatching{

    // Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
    // s = "aab", p = "c*a*b"
    // Output: true

    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null) return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] s, int i, char[] p, int j){
        if(i == s.length && j == p.length) return true;
        if(i != s.length && j == p.length) return false;

        if(j + 1 < p.length && p[j + 1] == '*'){
            if((i < s.length && s[i] == p[j]) || (p[j] == '.' && i < s.length)){
                return matchCore(s, i + 1, p, j + 2) || // 匹配1个
                        matchCore(s, i + 1, p, j) || // *匹配1个以上
                        matchCore(s, i, p, j + 2); // *匹配0个
            }else{
                return matchCore(s, i, p, j + 2);
            }
        }
        if((i < s.length && s[i] == p[j]) || ((p[j] == '.' && i < s.length))){
            return matchCore(s, i + 1, p, j + 1);
        }
        return false;
    }

}