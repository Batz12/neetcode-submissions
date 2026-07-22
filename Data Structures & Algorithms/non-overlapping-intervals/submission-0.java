class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int cnt = 0;

        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if(curStart < prevEnd) {
                prevEnd = Math.min(prevEnd, curEnd);
                cnt++;
            } else {
                prevEnd = curEnd;
            }

        }

        return cnt;
    }
}
