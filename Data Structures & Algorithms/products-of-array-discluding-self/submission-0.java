class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] prefixProduct = new int[len];
        int[] suffixProduct = new int[len];

        // Set first item in prefix and last item in suffix arrays = 1.
        prefixProduct[0] = 1;
        suffixProduct[len - 1] = 1;

        // Calculate prefix and suffix products at ith index by excluding ith item.
        for (int i = 1, j = len - 2; i < len && j >= 0; i++, j--) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
            suffixProduct[j] = suffixProduct[j + 1] * nums[j + 1];
        }

        // Use prefix and suffix arrays to find the total product at ith index
        for (int i = 0; i < len; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;
    }
}  
