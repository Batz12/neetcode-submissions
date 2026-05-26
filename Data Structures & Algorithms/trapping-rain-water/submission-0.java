class Solution {
    public int trap(int[] height) {
        int[] topHeightsFromLeft = new int[height.length];
        int[] topHeightsFromRight = new int[height.length];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < height.length; i++) {
            if(height[i] > max) {
                max = height[i];
            }
            topHeightsFromLeft[i] = max;
        }

        max = Integer.MIN_VALUE;

        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > max) {
                max = height[i];
            }
            topHeightsFromRight[i] = max;
        }

        int totalVolume = 0;

        for(int i = 0; i < height.length; i++) {
            int smallestHeight = Math.min(topHeightsFromLeft[i], topHeightsFromRight[i]);
            totalVolume += (smallestHeight - height[i]);
        }

        return totalVolume;
    }
}
