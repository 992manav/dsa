class Solution {
    public int unequalTriplets(int[] nums) {
        int[] freq = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i <= 1000; i++) {
            if(freq[i]!=0){
                for (int j = i + 1; j <= 1000; j++) {
                    if(freq[j]!=0){
                        for (int k = j + 1; k <= 1000; k++) {
                            if(freq[k]!=0){
                                 count += freq[i] * freq[j] * freq[k];
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
