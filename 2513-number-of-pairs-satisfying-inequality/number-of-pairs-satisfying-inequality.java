class Solution {

    int[] nums;
    int diff;

    long countPairs(int l1, int r1, int l2, int r2) {
        long count = 0;
        int i = l1;
        int j = l2;

        while (i <= r1 && j <= r2) {
            if (nums[i] <= nums[j] + diff) {
                count += (long) (r2 - j + 1);
                i++;
            } else {
                j++;
            }
        }

        return count;
    }

    void merge(int start1, int end1, int start2, int end2) {
        int[] arr = new int[end2 - start1 + 1];
        int i = start1;
        int j = start2;
        int index = 0;

        while (i <= end1 && j <= end2) {
            if (nums[i] <= nums[j]) {
                arr[index++] = nums[i++];
            } else {
                arr[index++] = nums[j++];
            }
        }

        while (i <= end1) {
            arr[index++] = nums[i++];
        }

        while (j <= end2) {
            arr[index++] = nums[j++];
        }

        for (int k = 0; k < arr.length; k++) {
            nums[start1 + k] = arr[k];
        }
    }

    long mergeSort(int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        long count = mergeSort(start, mid) + mergeSort(mid + 1, end);

        count += countPairs(start, mid, mid + 1, end);
        merge(start, mid, mid + 1, end);

        return count;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        nums = new int[n];
        this.diff = diff;

        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }

        return mergeSort(0, n - 1);
    }
}
