class Solution {
    public String minWindow(String s, String t) {
        // Use a sliding window approach
        // Expand the window by moving the right pointer r and adding characters into a window map.
        // Once the window has all required chars, shrink it from left and check if valid.
        if (t == null || t.isEmpty() || t.length() > s.length()) return "";

        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int finalL = -1, finalR = s.length();
        int l = 0; // start with left poinint at 0th index
        // Move r towards right
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            while (isMatchFound(countT, window)) {
                if ((r - l + 1) < (finalR - finalL + 1)) {
                    finalL = l;
                    finalR = r;
                }

                char lCh = s.charAt(l);
                window.put(lCh, window.get(lCh) - 1);
                l++;
            }
        }

        if (finalL != -1)
            return s.substring(finalL, finalR + 1);
        
        return "";
    }

    private boolean isMatchFound(
        HashMap<Character, Integer> countT, HashMap<Character, Integer> window
    ) {
        for(Map.Entry<Character, Integer> entry : countT.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue())
                return false;
        }

        return true;
    }
}
