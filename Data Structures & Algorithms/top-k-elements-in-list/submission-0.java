class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return usingMinHeap(nums, k);
    }

    private int[] usingMinHeap(int[] nums, int k) {
        // Build a map to store frequency of each number.
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Create a min heap of size k over the countMap. The numbers with 
        // frequency lesser than k would be removed from heap automatically.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (pq.size() == k) {
                int[] top = pq.peek();
                if (top[1] > entry.getValue()) continue;
                pq.poll();
            }

            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
