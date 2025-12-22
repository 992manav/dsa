import java.util.*;

public class Solution {

    public static int coinChange(int[] arr, int amt) {
        if (amt == 0) return 0;

        Arrays.sort(arr);
        int n = arr.length;

        if (n == 1) {
            if (amt % arr[0] == 0) return amt / arr[0];
            return -1;
        }

        int chhota = arr[0];
        int g = chhota;
        int idx = 1;

        while (idx < n && arr[idx] <= amt) {
            if (arr[idx] == amt) return 1;
            g = gcd(g, arr[idx]);
            arr[idx] -= chhota;
            idx++;
        }

        if (amt % g != 0) return -1;

        int minCnt = (amt - 1) / (arr[idx - 1] + chhota) + 1;
        int maxCnt = amt / chhota;

        for (int cnt = minCnt; cnt <= maxCnt; cnt++) {
            if (milSaktaHai(arr, 1, idx - 1, amt - cnt * chhota, cnt)) {
                return cnt;
            }
        }

        return -1;
    }

    private static boolean milSaktaHai(int[] arr, int l, int r, int amt, int limit) {
        if (amt == 0) return true;
        if (l > r || amt < arr[l] || amt / arr[r] > limit) return false;
        if (amt % arr[r] == 0) return true;

        for (int use = amt / arr[r]; use >= 0; use--) {
            if (milSaktaHai(arr, l, r - 1, amt - use * arr[r], limit - use)) {
                return true;
            }
        }

        return false;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
