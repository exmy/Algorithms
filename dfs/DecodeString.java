class DecodeString{

    // leetcode 394
    // s = "3[a]2[bc]", return "aaabcbc".
    // s = "3[a2[c]]", return "accaccacc".
    // s = "2[abc]3[cd]ef", return "abcabccdcdcdef"

    private int pos = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        return dfs(s);
    }
    
    private String dfs(String s){
        StringBuilder sb = new StringBuilder();
        String k = "";
        for(int i = pos; i < s.length(); i++){
            if(s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i)))                                        sb.append(s.charAt(i));
            else if(Character.isDigit(s.charAt(i))) k += s.charAt(i);
            else if(s.charAt(i) == '['){
                pos = i + 1;
                String next = dfs(s);
                System.out.println(next);
                for(int n = Integer.valueOf(k); n > 0; n--) sb.append(next);
                k = "";
                i = pos;
            }else if(s.charAt(i) == ']'){
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }


    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
  
}