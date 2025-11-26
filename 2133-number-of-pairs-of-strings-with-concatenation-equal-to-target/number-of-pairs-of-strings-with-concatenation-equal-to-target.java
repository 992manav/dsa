class Solution {

    boolean check(String target, String s) {
        if (s.length() <= target.length()) {
            int i = 0;
            for (i = 0; i < s.length(); i++) {
                if (target.charAt(i) != s.charAt(i)) {
                    return false;
                }
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];

            if (check(target, s)) {
                int idx = s.length();
                String suffix = target.substring(idx);
                if (map.containsKey(suffix)) {
                    count += map.get(suffix);
                }
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        map = new HashMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            String s = nums[i];

            if (check(target, s)) {
                int idx = s.length();
                String suffix = target.substring(idx);
                if (map.containsKey(suffix)) {
                    count += map.get(suffix);
                }
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }
}
