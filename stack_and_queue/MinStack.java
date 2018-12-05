public class MinStack{
    
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int val) {
        dataStack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()) minStack.push(val);
    }
    
    public void pop() {
        if(!dataStack.isEmpty()){
            if(dataStack.pop() == minStack.peek()){
                minStack.pop();
            }
        }
    }
    
    public int top() {
        if(!dataStack.isEmpty()){
            return dataStack.peek();
        }
        return -1; 
    }
    
    public int min() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}