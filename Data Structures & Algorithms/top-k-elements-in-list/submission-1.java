class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return usingMinHeap(nums, k);
        return usingBucketSort(nums, k);
    }

    private int[] usingBucketSort(int[] nums, int k) {
        // Build a map to store frequency of each number.
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Create a frequency array which can be of max length == nums.length
        List<Integer>[] freq = new List[nums.length + 1]; //including 0 length
        for (int i = 0; i <= nums.length; i++)
            freq[i] = new ArrayList<>();

        // Maintain the structure of a frequency -> List of numbers
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // Iterate from last (higher) frequency to capture k numbers
        int[] result = new int[k];
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int j = 0; j < freq[i].size(); j++) {
                result[k - 1] = freq[i].get(j);
                k--;
                if (k == 0) return result;
            }
        }

        return result;
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
