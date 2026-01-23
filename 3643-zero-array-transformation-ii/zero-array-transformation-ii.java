class Solution {
    int[] a;
    int[][] q;
    int[] p;

    boolean ok(int k) {
        int n = a.length;

        for (int i = 0; i <= n; i++) {
            p[i] = 0;
        }

        for (int i = 0; i < k; i++) {
            int[] x = q[i];

            int l = x[0];
            int r = x[1];
            int v = x[2];

            p[l] += v;

            int end = r + 1;
            if (end < n) {
                p[end] -= v;
            }
        }

        for (int i = 1; i < n; i++) {
            p[i] = p[i] + p[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int have = p[i];
            int need = a[i];

            if (have < need) {
                return false;
            }
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        a = nums;
        q = queries;

        int n = a.length;
        p = new int[n + 1];

        int l = 0;
        int r = q.length;
        int ans = -1;

        while (l <= r) {
            int m = (l + r) >> 1;

            boolean possible = ok(m);

            if (possible) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}
