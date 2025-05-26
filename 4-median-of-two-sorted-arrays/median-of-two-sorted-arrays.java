class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        int flag = 0;
        int prev = 0, curr = 0;
        int count = (int) Math.ceil((nums1.length + nums2.length) / 2.0);
        if ((nums1.length + nums2.length) % 2 == 0) {
            count++;
        }
        while (count > 0) {
            prev = curr;

            if (nums1.length == 0 && nums2.length == 0) {
                break;
            }

            if (nums1.length == 0) {
                curr = nums2[j];
                j++;
                flag = 2;
            } else if (nums2.length == 0 || (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j]))) {
                curr = nums1[i];
                i++;
                flag = 1;
            } else {
                curr = nums2[j];
                j++;
                flag = 2;
            }
            count--;
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}
