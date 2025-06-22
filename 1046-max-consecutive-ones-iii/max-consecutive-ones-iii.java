class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maxlen = 0; 

        while (i < nums.length && j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                if (k > 0) {
                    k--;
                    j++;
                } else {
                    maxlen = Math.max(maxlen, j - i);
                    while (nums[i] == 1) {
                        i++;
                    }
                    i++;
                    k++;
                }
            }
        }

        
        maxlen = Math.max(maxlen, j - i);
        
        return maxlen;
    }
}
