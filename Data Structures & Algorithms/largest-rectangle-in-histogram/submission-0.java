class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++) {
            // We should also consider the last bar as the boudnary to get the height
            int currentHeight = (i == heights.length)? 0 : heights[i];

            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]) { 
                int height = heights[stack.pop()];
                int width = 0;

                if(stack.isEmpty()) {
                    width = i; // Here the right boundary is nearby smaller and the left boundary is before 0 index
                } else {
                    int left = stack.peek();
                    width = i - left - 1; // the bar we are considering is the boundary and not part of the rectangle, hence -1
                }

                int area = (height * width);
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
