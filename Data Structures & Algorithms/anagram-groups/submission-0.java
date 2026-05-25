class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = CreateKeyByCharsCount(str);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String CreateKeyByCharsCount(String str) {
        if (str.isEmpty()) return "";
        int[] countArr = new int[26];
        for (char ch : str.toCharArray()) {
            countArr[ch - 'a']++;
        }

        return Arrays.toString(countArr);
    }
}
