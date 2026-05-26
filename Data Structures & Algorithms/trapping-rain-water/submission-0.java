class Solution {
    public int trap(int[] height) {
        int maxTrap = 0, last = height.length - 1;
        int[] leftMaxHeight = new int[last + 1];
        leftMaxHeight[0] = height[0];
        int[] rightMaxHeight = new int[last + 1];
        rightMaxHeight[last] = height[last];
        for (int i = 1, j = last - 1; i <= last && j >= 0; i++, j--) {
            leftMaxHeight[i] = Math.max(height[i], leftMaxHeight[i - 1]);
            rightMaxHeight[j] = Math.max(height[j], rightMaxHeight[j + 1]);
        }

        for (int i = 1; i < last; i++) {
            maxTrap += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }

        return maxTrap;
    }
}
