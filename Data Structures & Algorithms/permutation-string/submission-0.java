class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Check if s2 is smaller than s1
        if (s1.length() > s2.length()) return false;

        // Create 2 frequency arrays for s1 and s2 and initialize till s1 length
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        // Maintain a variable matches to decide at any point in time whether
        // a permuted string found in s2 against s1
        int matches = 0;
        for (int i = 0; i < 26; i++)
            if (s1Freq[i] == s2Freq[i]) 
                matches++;
        

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            // Check whether including current right character gives matches = 26
            int index = s2.charAt(right) - 'a';
            s2Freq[index]++;
            if (s1Freq[index] == s2Freq[index]) matches++;
            else if (s1Freq[index] + 1 == s2Freq[index]) matches--;

            index = s2.charAt(left) - 'a';
            s2Freq[index]--;
            if (s1Freq[index] == s2Freq[index]) matches++;
            else if (s1Freq[index] - 1 == s2Freq[index]) matches--;

            left++;
        }

        return matches == 26;
    }
}
