class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                List<List<Integer>> triplets = findTriplets(nums, i);
                for(List<Integer> triplet : triplets)
                    result.add(triplet);
            }
        }

        return result;
    }

    private List<List<Integer>> findTriplets(int[] nums, int start) {
        List<List<Integer>> triplets = new ArrayList<>();
        int left = start + 1, right = nums.length - 1;
        while(left < right) {
            int sum = nums[start] + nums[left] + nums[right];
            if (sum == 0) {
                triplets.add(Arrays.asList(nums[start], nums[left], nums[right]));
                left++;
                right--;
            }
            else if (sum > 0)
                right--;
            else 
                left++;
            
            while(left > start + 1 && left < right && nums[left - 1] == nums[left])
                    left++;

            while(right > left && right < nums.length - 1 && nums[right + 1] == nums[right]) 
                right--;
        }

        return triplets;
    }
}
