class Solution {
    public int longestConsecutive(int[] nums) {
        // Since we want to solve this problem in O(n), sorting and bruteforce
        // are not acceptable.
        // we can leverage the constrain in the question which says the sequence
        // must be +1. i.e. if a num doesn't have num - 1, then it can become a start
        // of new subsequence.

        // Use a hashset to keep all the input nums for O(1) lookup.
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        // Iterate over the nums array and compute the longest subsequence
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                // It is the start of a new subsequence.
                int len = 1;
                // Find all next num + 1 in set to know the max possible length
                while(set.contains(num + len)) len++;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
