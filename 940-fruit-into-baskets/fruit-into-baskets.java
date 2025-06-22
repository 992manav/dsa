class Solution {
    public int totalFruit(int[] nums) {
        int i = 0, j = 0;
        int type1 = nums[0], type2 = nums[0];
        int type1_index = 0, type2_index = 0;
        int maxlen = 0;

        while (j < nums.length) {
            if (nums[j] == type1) {
                type1_index = j;
                j++;
            } else {
                if (type2 == type1) {
                    type2 = nums[j];
                    type2_index = j;
                    j++;
                } else if (nums[j] == type2) {
                    type2_index = j;
                    j++;
                } else {
                    maxlen = Math.max(maxlen, j - i);
                    if(type1_index<type2_index){
                         i = type1_index + 1;
                          type1 = type2;
                        type1_index = type2_index;
                    }
                    else{
                         i = type2_index + 1;
                    }
                  
                    type2 = nums[j];
                    type2_index = j;
                    j++;
                }
            }
        }

        return Math.max(maxlen, j - i);
    }
}
