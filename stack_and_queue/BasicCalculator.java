class BasicCalculator{

   // leetcode 224
   // Implement a basic calculator to evaluate a simple expression string.
   // The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

   // Input: "(1+(4+5+2)-3)+(6+8)", Output: 23

   public int calculate(String s) {
        int n = s.length(), ans = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(Character.isDigit(s.charAt(i))){
                int t = s.charAt(i) - '0';
                while(i + 1 < n && Character.isDigit(s.charAt(i+1))){
                    t = t * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                ans += t * sign;
            }else if(s.charAt(i) == '+') sign = 1;
            else if(s.charAt(i) == '-') sign = -1;
            else if(s.charAt(i) == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }else if(s.charAt(i) == ')'){
                ans = ans * stack.pop() + stack.pop();
            }
        }
        return ans;
    }
}