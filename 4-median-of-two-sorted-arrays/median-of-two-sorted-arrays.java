class Solution {

    int check(int[] A, int[] B, int mid) {
        int total_elements = (A.length + B.length) / 2;
        int no_B = total_elements - mid;

        int l1 = mid - 1;
        int l2 = no_B - 1;
        int r1 = mid;
        int r2 = no_B;

        int left1 = (l1 >= 0) ? A[l1] : Integer.MIN_VALUE;
        int left2 = (l2 >= 0) ? B[l2] : Integer.MIN_VALUE;
        int right1 = (r1 < A.length) ? A[r1] : Integer.MAX_VALUE;
        int right2 = (r2 < B.length) ? B[r2] : Integer.MAX_VALUE;

        if (left1 > right2) return -1;
        if (left2 > right1) return 1;
        return 0;
    }

    double calculateMedian(int[] A, int[] B, int mid, boolean isOdd) {
        int total_elements = (A.length + B.length) / 2;
        int no_B = total_elements - mid;

        int l1 = mid - 1;
        int l2 = no_B - 1;
        int r1 = mid;
        int r2 = no_B;

        int left = Math.max((l1 >= 0) ? A[l1] : Integer.MIN_VALUE,
                            (l2 >= 0) ? B[l2] : Integer.MIN_VALUE);
        int right = Math.min((r1 < A.length) ? A[r1] : Integer.MAX_VALUE,
                             (r2 < B.length) ? B[r2] : Integer.MAX_VALUE);

        return isOdd ? right : (left + right) / 2.0;
    }

    double binarySearch(int[] A, int[] B, int low, int high, boolean isOdd) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = check(A, B, mid);
            if (res == 1) {
                low = mid + 1;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        return calculateMedian(A, B, ans, isOdd);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = ((nums1.length + nums2.length) % 2 != 0);
        int low = 0;
        int high;

        if (nums1.length < nums2.length) {
            high = nums1.length;
            return binarySearch(nums1, nums2, low, high, isOdd);
        } else {
            high = nums2.length;
            return binarySearch(nums2, nums1, low, high, isOdd);
        }
    }
}
