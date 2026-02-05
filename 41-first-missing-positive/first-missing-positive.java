class Solution {
    int[] nums;   

    void makenegative(int idx){
        if(nums[idx]>=0){
            nums[idx]=nums[idx]*-1;
        }
    }


    public int firstMissingPositive(int[] nums) {
        this.nums = nums;  

        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i]=Integer.MAX_VALUE;
            }
        }



        for(int i=0;i<n;i++){
            if(nums[i]!=Integer.MAX_VALUE){

                int idx=Math.abs(nums[i])-1;

                if(idx<=n-1 && idx>=0){
                    // if(nums[idx]==Integer.MAX_VALUE ){
                    //     makenegative(0);
                    //     nums[idx]=idx*-1;
                    // }
                    makenegative(idx);
                }


            }
        }

        //  System.out.println(Arrays.toString(nums));

        
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                // if(nums[i]==0){
                    return i+1;   
                // }
            }
        }

        return n+1;
    }
}