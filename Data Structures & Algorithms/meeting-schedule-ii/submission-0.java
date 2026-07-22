/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) {
            return 0;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        minHeap.add(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if(cur.start >= minHeap.peek()) {
                minHeap.poll();  
            }

            minHeap.add(cur.end);
        }
        
        return minHeap.size();
    }
}
