class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int maxVolume = 0;

        while(start < end) {
            int smallestHeight = Math.min(heights[start], heights[end]);
            
            int volume = (end - start) * smallestHeight;

            if(volume > maxVolume) {
                maxVolume = volume;
            }

            if(heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxVolume;
    }
}
