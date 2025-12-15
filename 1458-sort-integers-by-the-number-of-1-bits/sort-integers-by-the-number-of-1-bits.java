import java.util.*;
// 2¹³ = 8192
// 2¹⁴ = 16384
// So:

// yaml
// Copy code
// 8192 ≤ 10000 < 16384
// 👉 Matlab numbers 14 bits tak ja sakte hain
class Solution {
    public int[] sortByBits(int[] arr) {
    // 0010000
    // 1400000
        int base = 100000;

        for (int i = 0; i < arr.length; i++) {
            int bitCount = Integer.bitCount(arr[i]);
            arr[i] = bitCount * base + arr[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % base;
        }

        return arr;
    }
}
