class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // We will consider nums1 as the shorter array
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;

        // Binary search on shorter array (to find the partitions - can be before or after the array as well)
        int low = 0;
        int high = m;
        double median = 0;
        int half = (m + n + 1) / 2;

        while(low <= high) {
            int mid1 = low + (high - low)/2;

            int partition1 = mid1;
            int partition2 = half - mid1;

            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;

            if((partition1 - 1) >= 0) {
                left1 = nums1[partition1 - 1];
            } 
            
            if(partition1 < m) {
                right1 = nums1[partition1];
            }

            if((partition2 - 1) >= 0) {
                left2 = nums2[partition2 - 1];
            }

            if(partition2 < n) {
                right2 = nums2[partition2];
            }

            if(left1 <= right2 && left2 <= right1) {
                if(((m + n) % 2) != 0) {
                    median = Math.max(left1, left2); 
                } else {
                    int leftMax =  Math.max(left1, left2); 
                    int rightMin = Math.min(right1, right2);
                    median = (leftMax + rightMin) / 2.0;
                }
                break;
            } else if(left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
           

        }

        return median;
    }
}
