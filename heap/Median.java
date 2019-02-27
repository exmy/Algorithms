public class Median{

    // 数据流中的中位数

    // 左边大顶堆，右边小顶堆
    // 维持大顶堆的数都小于等于小顶堆的数，且两者的个数相等或差1。平均数就在两个堆顶的数之中
    public PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void Insert(Integer num) {
        if(max.isEmpty() || num <= max.peek()) max.offer(num);
        else min.offer(num);
        if(max.size() == min.size() + 2) min.offer(max.poll());
        if(max.size() + 1 == min.size()) max.offer(min.poll());
    }

    public Double GetMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek()) / 2.0 : (double)max.peek();
    }
    
}