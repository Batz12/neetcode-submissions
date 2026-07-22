class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<int[]>();
        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] cur = intervals[i];

            if(cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                result.add(cur);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
