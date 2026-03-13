import java.util.*;

class Solution {

    int[] nums;
    int n;
    int h;

    int bs(int val,long max){

        int low=1;
        int high=h;
        int ans=0;

        while(low<=high){

            int mid=(low+high)/2;

            long x=(long)mid*(mid+1)/2*val;

            if(x>max){
                high=mid-1;
            }else{
                ans=mid;
                low=mid+1;
            }
        }

        return ans;
    }

    boolean check(long max){

        long ans=0;

        for(int i=0;i<n;i++){

            int j=bs(nums[i],max);

            ans+=j;
        }

        if(ans>=h){
            return true;
        }else{
            return false;
        }
    }

    public long minNumberOfSeconds(int h, int[] nums) {

        this.nums=nums;
        this.n=nums.length;
        this.h=h;

        Arrays.sort(nums);

        long max=nums[n-1];

        long low=1;
        long high=(long)h*(h+1)/2*max;

        long ans=low;

        while(low<=high){

            long mid=(low+high)/2;

            if(check(mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}