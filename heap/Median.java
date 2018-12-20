public class Median{

    // 左边小顶堆，右边大顶堆
    public PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> max = new PriorityQueue<>();

    public void Insert(Integer num) {
        if(min.isEmpty() || num <= min.peek()) min.offer(num);
        else max.offer(num);
        if(min.size() == max.size() + 2) max.offer(min.poll());
        if(min.size() + 1 == max.size()) min.offer(max.poll());
    }

    public Double GetMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek()) / 2.0 : (double)min.peek();
    }
    
}