class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix_sum += nums[i];
            int r = prefix_sum % k;

            if (map.containsKey(r)) {
                if (i - map.get(r) > 1) return true;
            } else {
                map.put(r, i);
            }
        }
        return false;
    }
}
