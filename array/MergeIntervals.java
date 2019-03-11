class MergeIntervals{

    // leetcode 56
    // Given a collection of intervals, merge all overlapping intervals.

    // Input: [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        
        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals){
            if(interval.start <= end) end = Math.max(end, interval.end);
            else{
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}