class Solution {
    public int rob(int[] nums) {
        int prevRob1 = 0, prevRob2 = 0;
        for (int num : nums) {
            int temp = Math.max(prevRob1, prevRob2 + num);
            prevRob2 = prevRob1;
            prevRob1 = temp;
        }

        return prevRob1;
    }
}
