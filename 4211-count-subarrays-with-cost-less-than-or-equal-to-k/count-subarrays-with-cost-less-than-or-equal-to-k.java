class Solution {

    int[] segtreemin;
    int[] segtreemax;
    int[] nums;

    int buildmin(int idx, int l, int r) {
        if (l == r) {
            return segtreemin[idx] = nums[l];
        }

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int mid = (l + r) / 2;

        int lst = buildmin(left, l, mid);
        int rst = buildmin(right, mid + 1, r);

        return segtreemin[idx] = Math.min(lst, rst);
    }

    int buildmax(int idx, int l, int r) {
        if (l == r) {
            return segtreemax[idx] = nums[l];
        }

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int mid = (l + r) / 2;

        int lst = buildmax(left, l, mid);
        int rst = buildmax(right, mid + 1, r);

        return segtreemax[idx] = Math.max(lst, rst);
    }

    int querymin(int ql, int qr, int idx, int l, int r) {
        if (qr < l || ql > r) {
            return Integer.MAX_VALUE;
        }

        if (ql <= l && r <= qr) {
            return segtreemin[idx];
        }

        int mid = (l + r) / 2;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        int lst = querymin(ql, qr, left, l, mid);
        int rst = querymin(ql, qr, right, mid + 1, r);

        return Math.min(lst, rst);
    }

    int querymax(int ql, int qr, int idx, int l, int r) {
        if (qr < l || ql > r) {
            return Integer.MIN_VALUE;
        }

        if (ql <= l && r <= qr) {
            return segtreemax[idx];
        }

        int mid = (l + r) / 2;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        int lst = querymax(ql, qr, left, l, mid);
        int rst = querymax(ql, qr, right, mid + 1, r);

        return Math.max(lst, rst);
    }

    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        this.nums = nums;

        segtreemin = new int[4 * n];
        segtreemax = new int[4 * n];

        buildmin(0, 0, n - 1);
        buildmax(0, 0, n - 1);

        int i = 0;
        int j = 0;
        long count = 0;

        while (j < n) {

            int max = querymax(i, j, 0, 0, n - 1);
            int min = querymin(i, j, 0, 0, n - 1);

            long cost = (long)(max - min) * (j - i + 1);

            if (cost > k) {
                i++;
            } else {
                count += (j - i + 1);
                j++;
            }
        }

        return count;
    }

}
