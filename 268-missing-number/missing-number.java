class Solution {

    int[] nums;   

    void makenegative(int idx){
        if(nums[idx]>0){
            nums[idx]=nums[idx]*-1;
        }
    }

    public int missingNumber(int[] nums) {
        this.nums = nums;  

        int n=nums.length;
        for(int i=0;i<n;i++){
            int idx=Math.abs(nums[i]);
            if(idx<=n-1){
                if(nums[idx]==0){
                    makenegative(0);
                    nums[idx]=idx*-1;
                }
               makenegative(idx);
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                if(nums[i]==0){
                    if(i==0){
                        continue;
                    }
                }
                return i;
            }
        }

        return n;
    }
}
