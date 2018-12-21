public class RegMatching{

    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null) return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] s, int i, char[] p, int j){
        if(i == s.length && j >= p.length) return true;
        if(i != s.length && j == p.length) return false;

        if(j + 1 < p.length && p[j + 1] == '*'){
            if((i < s.length && s[i] == p[j]) || (p[j] == '.' && i < s.length)){
                return matchCore(s, i + 1, p, j + 2) ||
                        matchCore(s, i + 1, p, j) ||
                        matchCore(s, i, p, j + 2);
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