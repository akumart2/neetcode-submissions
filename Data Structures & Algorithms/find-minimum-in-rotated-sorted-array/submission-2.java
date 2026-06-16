class Solution {
    public int findMin(int[] nums) {
        // Basically, we want to find the pivot point i.e. start point of original array.
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[0]) end = mid - 1;
            else start = mid + 1;
        }

        // Already sorted
        return nums[0];
    }
}
