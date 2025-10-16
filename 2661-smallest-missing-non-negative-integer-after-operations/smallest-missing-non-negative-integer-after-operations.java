class Solution {

    int k;
    int[] nums;

    int replace(int num) {
        int pos = num;
        if (num < 0) {
            pos = Math.abs(num);
            int r = pos % k;
            if (r == 0) {
                return 0;
            }
            return k - r;
        } else {
            int r = pos % k;
            if (r == 0) {
                return 0;
            }
            return r;
        }
    }

    public int findSmallestInteger(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        int n = nums.length;
        int[] freq = new int[k];
        for (int i = 0; i < n; i++) {
            int curr = ((nums[i] % k) + k) % k;
            freq[curr]++;
        }
        int minFreq = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < k; i++) {
            if (freq[i] < minFreq) {
                minFreq = freq[i];
                minIndex = i;
            }
        }
        return minFreq * k + minIndex;
    }
}
