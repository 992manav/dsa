import java.util.*;

class Solution {
    static final int MOD = (int) 1e9 + 7;
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

    private static int pow2mod(int exp) {
        long res = 1, base = 2;
        while (exp > 0) {
            if ((exp & 1) != 0) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> lst = new ArrayList<>();
        int idx = find_biggest(n), sum = 0;
        for (int i = idx; i >= 0; i--) {
            if (sum + arr[i] <= n) {
                lst.add(i);  
                sum += arr[i];
            }
        }

        int m = lst.size();
        int[] prefix = new int[m];
        prefix[0] = lst.get(0);
        for (int i = 1; i < m; i++) {
            prefix[i] = prefix[i - 1] + lst.get(i);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = m - 1 - queries[i][1];
            int right = m - 1 - queries[i][0];
            int expSum = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
            res[i] = pow2mod(expSum);
        }
        return res;
    }
}
