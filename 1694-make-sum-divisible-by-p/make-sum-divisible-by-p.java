class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        long r = sum % p;
        if (r == 0) return 0;

        Map<Long, Integer> map = new HashMap<>();
        long pref = 0;
        int len = Integer.MAX_VALUE;

        map.put(0L, -1);

        for (int i = 0; i < n; i++) {
            pref += nums[i];
            long target = (pref - r) % p;
            if (target < 0) target += p;

            if (map.containsKey(target)) {
                int j = map.get(target);
                len = Math.min(len, i - j);
            }

            map.put(pref % p, i);
        }

        if (len == Integer.MAX_VALUE || len == n) return -1;
        return len;
    }
}
