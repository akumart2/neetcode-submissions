class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length >= nums2.length)
            return findMedian(nums1, nums2, 0, nums1.length);
        else
            return findMedian(nums2, nums1, 0, nums2.length);
    }

    private double findMedian(int[] list1, int[] list2, int low, int high) {
        int len1 = list1.length, len2 = list2.length;
        while(low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (len1 + len2) / 2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : list1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : list2[cut2 - 1];
            int r1 = cut1 == len1 ? Integer.MAX_VALUE : list1[cut1];
            int r2 = cut2 == len2 ? Integer.MAX_VALUE : list2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if ((len1 + len2) % 2 == 0)
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else
                    return Math.min(r1, r2);
            }
            else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }

        return 0;
    }
}
