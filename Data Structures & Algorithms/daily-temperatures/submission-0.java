class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!indexStack.isEmpty()) {
                int peekedIndex = indexStack.peek();
                if (temperatures[peekedIndex] < temperatures[i]) {
                    result[peekedIndex] = i - peekedIndex;
                    indexStack.pop();
                }
                else break;
            }

            indexStack.push(i);
        }

        return result;
    }
}
