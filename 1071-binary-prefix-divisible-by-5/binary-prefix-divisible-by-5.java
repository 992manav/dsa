class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> lst = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr;
            if (nums[i] == 1) {
                curr = prev * 2 + 1;
            } else {
                curr = prev * 2;
            }
            curr = curr % 5;
            prev = curr;
            if (curr % 5 == 0) {
                lst.add(true);
            } else {
                lst.add(false);
            }
        }
        return lst;
    }
}
