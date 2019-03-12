class GenerateParentheses{

    // leetcode 22
    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    /* 
        n = 3
        [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
        ]
    */

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", n, 0);
        return ans;
    }
    // left 表示 可以输出 left 个左括号，right 表示可以输出 right 个右括号
    // 只有输出一个左括号，才能输出一个右括号
    private void dfs(String s, int left, int right){
        if(left == 0 && right == 0){
            ans.add(s);
            return;
        }
        if(left > 0)  dfs(s + "(", left - 1, right + 1);
        if(right > 0) dfs(s + ")", left, right - 1);    
    }
}