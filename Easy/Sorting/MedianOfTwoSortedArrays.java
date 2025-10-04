class Solution {
    private int p1 = 0, p2 = 0;


     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // if summed array is even
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i)  // ** note the -1
                int tmp = getMin(nums1, nums2);
            
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } 
        
        // if summed array is odd
        else {
            for (int i = 0; i < (m + n) / 2; ++i) 
                int tmp = getMin(nums1, nums2);
            
            return getMin(nums1, nums2);
        }
    }



    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }

   
}