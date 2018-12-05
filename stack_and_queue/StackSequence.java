public class StackSequence{

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 0; i < pushA.length;){
            stack.push(pushA[i++]);
            while(j < popA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}