import java.util.*;

class Solution {
    static final int MOD = (int) (1e9 + 7);
    static int[] arr = new int[30];
    static {
        for (int i = 0; i < 30; i++) {
            arr[i] = 1 << i;
        }
    }

    static int find_biggest(int n) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> lst = new ArrayList<>();
        int idx = find_biggest(n), sum = 0;
        for (int i = idx; i >= 0; i--) {
            if (sum + arr[i] <= n) {
                lst.add(arr[i]);
                sum += arr[i];
            }
        }

        int[] prefix = new int[lst.size()];
        prefix[0] = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            prefix[i] = (int) (((long) prefix[i - 1] * lst.get(i)) % MOD);
        }

        int[] res = new int[queries.length];
        int m = lst.size();
        for (int i = 0; i < queries.length; i++) {
            int left = m - 1 - queries[i][1];
            int right = m - 1 - queries[i][0];
            if (left == 0) {
                res[i] = prefix[right];
            } else {
                res[i] = (int) ((prefix[right] * modInverse(prefix[left - 1])) % MOD);
            }
        }
        return res;
    }

    private static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    private static long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
