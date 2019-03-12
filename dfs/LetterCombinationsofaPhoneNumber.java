class LetterCombinationsOfAPhoneNumber{

    // leetcode 17
    // Given a string containing digits from 2-9 inclusive, 
    // return all possible letter combinations that the number could represent.

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.length() == 0) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        ans.add("");
        for(int i = 0; i < digits.length(); ++i){
            int idx = digits.charAt(i) - '0';
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char c : mapping[idx].toCharArray()) ans.add(t + c);
            }
        }
        return ans;
    }


    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}