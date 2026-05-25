class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch(ch) {
                case ')': if (!isAcceptable('(', stack)) return false; else break;
                case '}': if (!isAcceptable('{', stack)) return false; else break;
                case ']': if (!isAcceptable('[', stack)) return false; else break;
                default: stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    private boolean isAcceptable(char ch, Stack<Character> stack) {
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if (top != ch) return false;
        return true;
    }
}
