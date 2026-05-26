class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                switch(token) {
                    case "+": result = operand1 + operand2; break;
                    case "-": result = operand1 - operand2; break;
                    case "*": result = operand1 * operand2; break;
                    case "/": result = operand1 / operand2; break;
                }
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
