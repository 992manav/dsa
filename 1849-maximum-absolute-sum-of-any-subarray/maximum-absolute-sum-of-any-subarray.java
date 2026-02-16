class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int sum=0;
        int max=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum<0){
                
                sum=0;
                
            }
            max=Math.max(max,sum);
        }

        max=Math.max(max,sum);

        sum=0;

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>0){
                
                sum=0;
            }
            min=Math.min(min,sum);
        }

        


        return Math.max(Math.abs(min),Math.abs(max));



    }
}