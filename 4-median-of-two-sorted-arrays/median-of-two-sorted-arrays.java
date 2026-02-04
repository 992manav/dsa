class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int tot = n + m;
        int count = tot / 2 + tot % 2;

        int i = 0;
        int j = 0;
        int ans = 0;

        while (count > 0) {

            if (i < n && j < m) {
                if (nums1[i] > nums2[j]) {
                    ans = nums2[j];
                    j++;
                } else {
                    ans = nums1[i];
                    i++;
                }
            } else {
                if (i == n) {
                    ans = nums2[j];
                    j++;
                } else {
                    ans = nums1[i];
                    i++;
                }
            }

            count--;
        }

        if (tot % 2 == 0) {

            if (i < n && j < m) {
                if (nums1[i] > nums2[j]) {
                    return (ans + nums2[j]) / 2.0;
                } else {
                    return (ans + nums1[i]) / 2.0;
                }
            } else {
                if (i == n) {
                    return (ans + nums2[j]) / 2.0;
                } else {
                    return (ans + nums1[i]) / 2.0;
                }
            }

        } else {
            return ans;
        }
    }
}
