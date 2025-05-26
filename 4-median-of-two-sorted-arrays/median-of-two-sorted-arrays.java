class Solution {

    int check(int[] nums1, int[] nums2, int mid, boolean isOdd) {
        int total_elements = (nums1.length + nums2.length) / 2;
        int no_nums2 = total_elements - mid;

        int l1 = mid - 1;
        int l2 = no_nums2 - 1;
        int r1 = mid;
        int r2 = no_nums2;

        int left1 = (l1 >= 0) ? nums1[l1] : Integer.MIN_VALUE;
        int left2 = (l2 >= 0) ? nums2[l2] : Integer.MIN_VALUE;
        int right1 = (r1 < nums1.length) ? nums1[r1] : Integer.MAX_VALUE;
        int right2 = (r2 < nums2.length) ? nums2[r2] : Integer.MAX_VALUE;

        if (left1 > right2) return -1;
        if (left2 > right1) return 1;
        return 0;
    }

    int check2(int[] nums1, int[] nums2, int mid, boolean isOdd) {
        int total_elements = (nums1.length + nums2.length) / 2;
        int no_nums1 = total_elements - mid;

        int l1 = mid - 1;
        int l2 = no_nums1 - 1;
        int r1 = mid;
        int r2 = no_nums1;

        int left1 = (l1 >= 0) ? nums2[l1] : Integer.MIN_VALUE;
        int left2 = (l2 >= 0) ? nums1[l2] : Integer.MIN_VALUE;
        int right1 = (r1 < nums2.length) ? nums2[r1] : Integer.MAX_VALUE;
        int right2 = (r2 < nums1.length) ? nums1[r2] : Integer.MAX_VALUE;

        if (left1 > right2) return -1;
        if (left2 > right1) return 1;
        return 0;
    }

    double median_calculate(int[] nums1, int[] nums2, int mid, boolean isOdd) {
        int total_elements = (nums1.length + nums2.length) / 2;
        int no_nums2 = total_elements - mid;

        int l1 = mid - 1;
        int l2 = no_nums2 - 1;
        int r1 = mid;
        int r2 = no_nums2;

        int left = Math.max((l1 >= 0) ? nums1[l1] : Integer.MIN_VALUE,
                            (l2 >= 0) ? nums2[l2] : Integer.MIN_VALUE);
        int right = Math.min((r1 < nums1.length) ? nums1[r1] : Integer.MAX_VALUE,
                             (r2 < nums2.length) ? nums2[r2] : Integer.MAX_VALUE);

        if (isOdd) return right;
        return (left + right) / 2.0;
    }

    double median_calculate2(int[] nums1, int[] nums2, int mid, boolean isOdd) {
        int total_elements = (nums1.length + nums2.length) / 2;
        int no_nums1 = total_elements - mid;

        int l1 = mid - 1;
        int l2 = no_nums1 - 1;
        int r1 = mid;
        int r2 = no_nums1;

        int left = Math.max((l1 >= 0) ? nums2[l1] : Integer.MIN_VALUE,
                            (l2 >= 0) ? nums1[l2] : Integer.MIN_VALUE);
        int right = Math.min((r1 < nums2.length) ? nums2[r1] : Integer.MAX_VALUE,
                             (r2 < nums1.length) ? nums1[r2] : Integer.MAX_VALUE);

        if (isOdd) return right;
        return (left + right) / 2.0;
    }

    double binary_search(int[] nums1, int[] nums2, int low, int high, boolean isOdd) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = check(nums1, nums2, mid, isOdd);
            if (res == 1) {
                low = mid + 1;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        return median_calculate(nums1, nums2, ans, isOdd);
    }

    double binary_search2(int[] nums1, int[] nums2, int low, int high, boolean isOdd) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = check2(nums1, nums2, mid, isOdd);
            if (res == 1) {
                low = mid + 1;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        return median_calculate2(nums1, nums2, ans, isOdd);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = ((nums1.length + nums2.length) % 2 != 0);
        int low = 0;
        int high;

        if (nums1.length < nums2.length) {
            high = nums1.length;
            return binary_search(nums1, nums2, low, high, isOdd);
        } else {
            high = nums2.length;
            return binary_search2(nums1, nums2, low, high, isOdd);
        }
    }
}
