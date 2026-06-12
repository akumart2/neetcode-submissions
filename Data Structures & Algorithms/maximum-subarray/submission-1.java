class Solution {
    public int maxSubArray(int[] nums) {
        // There are 2 types of questions could be asked in this
        // 1. Simply return the max subarray sum. Refer method maxSubArraySum.
        // 2. Find the max subarray sum and return array values. Refer method maxSubArrayList
        // return maxSubArraySum(nums);
        List<Integer> subArr = maxSubArrayList(nums);
        int sum = 0;
        for(int num : subArr)
            sum += num;
        
        return sum;
    }

    private int maxSubArraySum(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    private List<Integer> maxSubArrayList(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int startIndex = 0, endIndex = 0, tempStart = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                startIndex = tempStart + 1;
                endIndex = i;
            }

            if (sum <= 0) {
                sum = 0;
                tempStart = i;
            }
        }

        List<Integer> subArr = new ArrayList<>();
        for(int j = startIndex; j <= endIndex; j++)
            subArr.add(nums[j]);
        
        return subArr;
    }
}
