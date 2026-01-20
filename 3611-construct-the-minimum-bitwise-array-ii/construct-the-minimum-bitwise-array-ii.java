class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int cur = nums.get(i);
            int jawab = -1;
            int num = nums.get(i);
            int sub = 1;

            while (cur != 0) {
                int r = (cur & 1);
                if (r == 0) {
                    jawab = num - (sub >> 1);
                    break;
                }
                cur = cur >> 1;
                sub = sub << 1;
            }

            ans[i] = jawab;

            if (jawab == -1) { ans[i] = (nums.get(i) + 1) / 2 - 1; } 
            
            if ( (ans[i] | (ans[i] + 1)) != nums.get(i) ) { ans[i] = -1; }
        }

        return ans;
    }
}
