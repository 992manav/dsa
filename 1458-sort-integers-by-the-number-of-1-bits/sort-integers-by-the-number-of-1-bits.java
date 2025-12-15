import java.util.*;
// 2¹³ = 8192
// 2¹⁴ = 16384
// So:

// 8192 ≤ 10000 < 16384
// 👉 Matlab numbers 14 bits tak ja sakte hain
//
// int ki max value = 2³¹ - 1 = 2147483647
// Isliye encoding karte waqt:
// bitCount * base + arr[i] ≤ 2147483647 hona chahiye
// yaha base = 100000 safe hai kyunki:
// max bitCount (for <=10000) ≈ 14
// 14 * 100000 + 10000 = 1410000 (int limit ke andar)
class Solution {
    public int[] sortByBits(int[] arr) {
    // 0010000
    // 1400000
        int base = 100000;

        // encode: bitCount ne high weight aapiye
        for (int i = 0; i < arr.length; i++) {
            int bitCount = Integer.bitCount(arr[i]);
            arr[i] = bitCount * base + arr[i];
        }

        // normal sort
        Arrays.sort(arr);

        // decode: original number pacho laviye
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % base;
        }

        return arr;
    }
}
