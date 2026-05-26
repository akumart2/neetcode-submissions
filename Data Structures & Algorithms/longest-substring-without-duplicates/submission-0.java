class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] seen = new int[256];
        int start = 0, maxLength = 0;
        for(int end = 0; end < s.length(); end++) {
            start = Math.max(seen[s.charAt(end)], start);
            maxLength = Math.max(maxLength, end - start + 1);
            seen[s.charAt(end)] = end + 1;
        }

        return maxLength;
    }
}
