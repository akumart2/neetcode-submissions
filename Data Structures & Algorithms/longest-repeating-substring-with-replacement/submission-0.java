class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, maxFrequency = 0, maxLength = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
            // Somehow, updating maxFrequency with actual reduced freq is not needed.
            maxFrequency = Math.max(maxFrequency, countMap.get(currentChar));
            while ((right - left + 1) - maxFrequency > k) {
                // Remove char from left and update the countMap
                char leftMostChar = s.charAt(left);
                countMap.put(leftMostChar, countMap.get(leftMostChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
