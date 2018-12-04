public class StackBasedTwoQueue{

    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        queue1.offer(node);
    }

    public int pop() {
        if(queue1.isEmpty()) return -1;
        for(int i = 0; i < queue1.size() - 1; i++){
            queue2.offer(queue1.poll());
        }
        int ret = queue1.poll();
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return ret;
    }

}