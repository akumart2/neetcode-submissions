class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') list.add((char)(ch + 32));
            else if (ch >= 'a' && ch <= 'z') list.add(ch);
            else if (ch >= '0' && ch <= '9') list.add(ch);
        }

        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) != list.get(j)) return false;
        }

        return true;
    }
}
