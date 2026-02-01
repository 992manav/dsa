class Solution {
    public int longestSubarray(int[] nums) {
        
        int j=1;
        int n=nums.length;
        int max_len=-1;

        int[] suffix=new int[n];
        suffix[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                suffix[i]=suffix[i+1]+1;
            }else{
                suffix[i]=1;
            }
        }

        int i=0;

        while(j<n){
            if(nums[j]<nums[j-1]){
                
                int len=j-i;
                max_len=Math.max(len+1,max_len);
                i=j;

                
                if(j+1<n && nums[j+1]>=nums[j-1]){
                    max_len=Math.max(suffix[j+1]+1+len,max_len);
                }

                if(j-2>=0 && nums[j-2]<=nums[j]){
                    max_len=Math.max(suffix[j]+len,max_len);
                }


            }
            j++;
        }

        if(max_len==-1){
            return n;
        }

        int len=j-i;
        max_len=Math.max(len+1,max_len);

        return max_len;
    }
    
}
