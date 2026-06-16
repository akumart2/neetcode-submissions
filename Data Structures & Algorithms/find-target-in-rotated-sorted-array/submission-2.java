class Solution {
    public int search(int[] nums, int target) {
        int index = findPivotIndex(nums);
        System.out.println("I: " + index);
        if (index != 0) {
            if (nums[index] == target) return index;
            if (target >= nums[0]) return search(nums, target, 0, index - 1);
            else return search(nums, target, index + 1, nums.length - 1);
        }

        return search(nums, target, 0, nums.length - 1);
    }

    private int findPivotIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return mid;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid] < nums[0]) end = mid - 1;
            else start = mid + 1;
        }

        // Already sorted
        return 0;
    }

    private int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}
