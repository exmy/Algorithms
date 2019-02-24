class LongestValidParentheses{

    // leetcode 32
    // Given a string containing just the characters '(' and ')', 
    // find the length of the longest valid (well-formed) parentheses substring.

    // Input: ")()())"
    // Output: 4

    public int longestValidParentheses(String s) {
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans, i - stack.peek());
            }
        }
        return ans;
    }

}