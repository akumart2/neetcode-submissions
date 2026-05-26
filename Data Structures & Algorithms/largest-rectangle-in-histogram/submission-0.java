class Solution {
    public int largestRectangleArea(int[] heights) {
        // The approach would be to keep pushing the height indexes in a stack.
        // Stop push when stack top height is found > current height.
        // If we encountered a smaller height at ith index then we need to 
        // get the histogram processed from ith till the last hieght stored in stack.
        Stack<Integer> indexStack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < heights.length) {
            if (indexStack.isEmpty() || heights[indexStack.peek()] <= heights[i])
                indexStack.push(i++);
            else {
                int index = indexStack.pop();
                int span = indexStack.isEmpty() ? i : i - (indexStack.peek() + 1);
                int area = heights[index] * span;
                maxArea = Math.max(maxArea, area);
            }
        }

        while(!indexStack.isEmpty()) {
            int index = indexStack.pop();
            int span = indexStack.isEmpty() ? i : i - (indexStack.peek() + 1);
            int area = heights[index] * span;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
