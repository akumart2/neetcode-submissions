class Solution {
    public int climbStairs(int n) {
        //It's fibonacci series.
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prev1 = 1, prev2 = 2, curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev2 + prev1;
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }
}
