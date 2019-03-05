class CourseScheduleIII{

    // leetcode 630
    // There are n different online courses numbered from 1 to n.
    // Each course has some duration(course length) t and closed on dth day. 
    // A course should be taken continuously for t days and must be finished before or on the dth day. 
    // You will start at the 1st day.
    // Given n online courses represented by pairs (t,d), 
    // your task is to find the maximal number of courses that can be taken.

    // 思路：按照deadline排序，贪心策略，总是先解决最先结束的课程

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        int time = 0;
        for(int[] c: courses){
            time += c[0];
            pq.add(c[0]);
            if(time > c[1]) time -= pq.poll();
        }
        return pq.size();
    }
}