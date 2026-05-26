class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0, j = heights.length - 1;
        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (heights[i] < heights[j]) i++;
            else j--;
        }

        return maxArea;
    }
}
