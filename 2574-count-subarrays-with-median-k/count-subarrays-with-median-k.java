import java.util.*;

class Solution {

    int bs(int[] nums,int low,int high,int target){
        int ans=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans=i;
                break;
            }
        }

        return ans;
    }

    public int countSubarrays(int[] nums, int k) {

        int n=nums.length;
        int idx=bs(nums,0,n-1,k);

        int r=0;
        int l=0;

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=idx-1;i>=0;i--){
            if(nums[i]>k){
                r++;
            }else{
                l++;
            }

            int x=l-r;
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int ans=0;
        r=0;
        l=0;

        for(int i=idx;i<n;i++){

            if(nums[i]>k){
                r++;
            }else if(nums[i]<k){
                l++;
            }

            int x=r-l;

            if(map.containsKey(x)){
                ans+=map.get(x);
            }

            if(map.containsKey(x-1)){
                ans+=map.get(x-1);
            }

            if(x==0){
                ans++;
            }

            if(x==1){
                ans++;
            }
        }

        return ans;
    }
}