class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += nums1[i];
            if (nums1[i] == 0) {
                count++;
            }
        }

        long sum1 = 0;
        long count1 = 0;
        for (int i = 0; i < nums2.length; i++) {
            sum1 += nums2[i];
            if (nums2[i] == 0) {
                count1++;
            }
        }

        long tot = sum + count;
        long tot1 = sum1 + count1;

        if (count == 0 && count1 == 0) {
            if (sum != sum1) {
                return -1;
            } else {
                return sum;
            }
        }

        if (count == 0) {
            if (tot >= tot1) {
                return sum;
            } else {
                return -1;
            }
        } else if (count1 == 0) {
            if (tot <= tot1) {
                return sum1;
            } else {
                return -1;
            }
        } else {
            if (tot < tot1) {
                return tot1;
            } else {
                return tot;
            }
        }
    }
}
