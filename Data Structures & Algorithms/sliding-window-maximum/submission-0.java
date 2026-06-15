class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Approach: Use a doubly linked list to keep the indexes which are probable
        // candidates for the max within the current as well as future window.
        // As soon as we encounter an index pointing to an element which is max
        // for the current window, we can discard the previous stored indexes.
        LinkedList<Integer> dll = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // Remove the index from front which is outside of current window
            if (!dll.isEmpty() && dll.get(0) < i - k + 1)
                dll.removeFirst();
            
            // Remove the indexes from rear whose mapped nums are lesser than current num
            while (!dll.isEmpty() && nums[dll.getLast()] <= nums[i])
                dll.removeLast();
            
            // Add index of current number at rear
            dll.add(i);

            // Start populating the results after window is formed.
            if (i >= k - 1) {
                result[i - k + 1] = nums[dll.get(0)];
            }
        }

        return result;
    }
}
