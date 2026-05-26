class Solution {
    public int trap(int[] height) {
        // return usingPrefixSuffixArrays(height);
        return usingTwoPointers(height);
    }

    private int usingTwoPointers(int[] height) {
        int maxTrap = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        
        // Water depends on shorter wall between the left and right sides.
        // Either wall is shorter then other wall doesn't help at all.
        // Process left side height till the right side height is greater.
        // Process right side height till the left side height is greater.
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                maxTrap += leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                maxTrap += rightMax - height[right];
            }
        }

        return maxTrap;
    }

    private int usingPrefixSuffixArrays(int[] height) {
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
