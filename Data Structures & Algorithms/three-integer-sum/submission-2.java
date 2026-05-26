class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                List<List<Integer>> triplets = findTriplets(nums, nums[i], i + 1);
                for(List<Integer> triplet : triplets)
                    result.add(triplet);
            }
        }

        return result;
    }

    private List<List<Integer>> findTriplets(int[] nums, int firstNum, int start) {
        List<List<Integer>> triplets = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while(left < right) {
            int sum = firstNum + nums[left] + nums[right];
            if (sum == 0) {
                triplets.add(Arrays.asList(firstNum, nums[left], nums[right]));
                left++;
                right--;
            }
            else if (sum > 0)
                right--;
            else 
                left++;
            
            while(left > start && left < right && nums[left - 1] == nums[left])
                    left++;

            while(right > left && right < nums.length - 1 && nums[right + 1] == nums[right]) 
                right--;
        }

        return triplets;
    }
}
