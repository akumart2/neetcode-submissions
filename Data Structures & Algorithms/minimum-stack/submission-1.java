class MinStack {
    // The idea is that we are going to store the diff of val - min in stack instead
    // of actual values.
    // The moment a value is lesser than current min, the diff would be -ve, which 
    // basically becomes a signal for us to reset the min.
    long min;
    Stack<Long> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L); // min and val are same so the diff is 0.
            min = val;
        }
        else {
            stack.push(val - min);
            if (val - min < 0) min = val; // Update min
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        // Otherwise pop the element and see if min needs to be updated.
        long poppedVal = stack.pop();
        // poppedVal was computed as poppedVal = val - min.
        // Therefore, min = val - poppedVal.
        if (poppedVal < 0) min = min - poppedVal;
    }
    
    public int top() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        long topVal = stack.peek();
        // topVal was computed as topVal = val - min.
        // Therefore, to retrieve actual val we need to execute val = min + topVal.
        if (topVal > 0) return (int)(min + topVal);
        else return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}
