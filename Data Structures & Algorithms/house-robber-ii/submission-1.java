class Solution {
    public int rob(int[] nums) {
        /*
        To handle this, split the problem into two linear subproblems:
        Rob houses excluding the first house.
        Rob houses excluding the last house.
        */
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int amountExcludingHouse1 = rob(nums, 1, nums.length - 1);
        int amountExcludingHouseN = rob(nums, 0, nums.length - 2);
        return Math.max(amountExcludingHouse1, amountExcludingHouseN);
    }

    private int rob(int[] nums, int start, int end) {
        int prevRob1 = 0, prevRob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prevRob1, prevRob2 + nums[i]);
            prevRob2 = prevRob1;
            prevRob1 = temp;
        }

        return prevRob1;
    }
}
