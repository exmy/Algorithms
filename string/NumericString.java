public class NumericString{
    int i = 0;
    public boolean isNumeric(char[] s) {
        if(s == null || s.length == 0) return false;
        i = 0;

        if(s[i] == '+' || s[i] == '-') i++;
        if(i == s.length) return false;

        boolean numeric = true;
        scanDigits(s);
        if(i < s.length){
            if(s[i] == '.'){
                i++;
                scanDigits(s);
                if(i < s.length && (s[i] == 'e' || s[i] == 'E')) numeric = isExp(s);
            }else if(i < s.length && (s[i] == 'e' || s[i] == 'E'))  numeric = isExp(s);
            else numeric = false;
        }
        return numeric && i == s.length;
    }

    private void scanDigits(char[] s){
        while(i < s.length && Character.isDigit(s[i])) i++;
    }

    private boolean isExp(char[] s){
        if(s[i] != 'e' && s[i] != 'E') return false;
        i++;
        if(i < s.length && (s[i] == '+' || s[i] == '-')) i++;
        if(i == s.length) return false;
        scanDigits(s);
        return i == s.length;
    }
}