import java.util.*;

class Solution {

    int findnearestpow2(int target) {
        int pow = (int) (Math.log(target) / Math.log(2));
        int low = (int) Math.pow(2, pow);
        int high = (int) Math.pow(2, pow + 1);

        if (low == target) {
            return target;
        }

        if (target - low <= high - target) {
            return low;
        } else {
            return high;
        }
    }

    String decToBinary(int n) {
        StringBuilder bin = new StringBuilder();
        while (n > 0) {
            int bit = n % 2;
            bin.append((char) ('0' + bit));
            n = n / 2;
        }
        bin.reverse();
        return bin.toString();
    }

    boolean isPalindrom(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    boolean isBinaryPalindrome(int n) {
        if (n <= 0) {
            return false;
        }
        String bin = decToBinary(n);
        return isPalindrom(bin);
    }

    int ops(int num) {
        int bits = 31 - Integer.numberOfLeadingZeros(num);
        int ones = Integer.bitCount(num);
        return bits + ones;
    }

    public int[] minOperations(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int idx = 0; idx < n; idx++) {
            int num = nums[idx];

            if (isBinaryPalindrome(num)) {
                res[idx] = 0;
                continue;
            }

            int nearest = findnearestpow2(num);

            // Approach 1: Go via nearest power of 2
            int best = Math.abs(num - nearest) + ops(nearest) - 1;

            // Approach 2: Search for nearby binary palindromes directly
            int i = 1;
            int op = Integer.MAX_VALUE;

            while (i <= Math.min(num, 50000)) {
                if (num - i > 0 && isBinaryPalindrome(num - i)) {
                    op = i;
                    break;
                }
                if (isBinaryPalindrome(num + i)) {
                    op = i;
                    break;
                }
                i++;
            }

            res[idx] = Math.min(best, op);
        }

        return res;
    }
}