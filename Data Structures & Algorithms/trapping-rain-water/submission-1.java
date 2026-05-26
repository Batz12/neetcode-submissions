class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;

        // We need to just maintain what is current leftMax and rightMax (no need to store the whole prefix and whole suffix arrays)
        int leftMax = 0;
        int rightMax = 0;

        int totalVolume = 0;

        while(start < end) {
            if(height[start] < height[end]) {
                if(height[start] >= leftMax) {
                    leftMax = height[start];
                } else {
                    totalVolume += leftMax - height[start];
                }
                start++;
            } else {
                if(height[end] >= rightMax) {
                    rightMax = height[end];
                } else {
                    totalVolume += rightMax - height[end];
                }
                end--;
            }
        }

        return totalVolume;
    }
}
