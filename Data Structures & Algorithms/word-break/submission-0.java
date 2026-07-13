class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /* This is similar to longest increasing subsequence problem.
        * The idea is if I am at index i (assuming ith index is end of string) then
        * I want to know is there any possiblity that can make ith index true i.e. if
        * till ith index string can be formed from given set.
        * To know it basically I need to find all substrings of length 1 to i and check
        * whether two substrings for each partition e.g. [0 - 1] & [2 - i] are present in set.
        */
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (table[j] == true && wordSet.contains(s.substring(j, i))) {
                    table[i] = true;
                    break;
                }
            }
        }

        return table[s.length()];
    }
}
