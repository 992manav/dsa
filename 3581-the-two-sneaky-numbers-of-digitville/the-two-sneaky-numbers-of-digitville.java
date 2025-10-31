class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[101];
        int[] res = new int[2];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq[num]++; 

            if (freq[num] == 2) { 
                res[index] = num;
                index++;
            }
        }

        return res;
    }
}
