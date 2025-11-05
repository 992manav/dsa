import java.util.*;

class Solution {

    int binarySerch_l(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    int binarySerch_r(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=high;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] <= target){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int start=nums[0];
        int end=nums[n-1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for(int i=start;i<=end;i++){
            int target=i;
            int left=target-k;
            int right=target+k;
            int l=binarySerch_l(nums,left);
            int r=binarySerch_r(nums,right);
            int target_count=0;
            if(map.containsKey(target)){
                target_count =map.get(target);
            }
            int available = (r-l+1) - target_count;
            if(available > numOperations){
                int freq=numOperations + target_count;
                max=Math.max(max,freq);
            }else{
                int freq=available + target_count;
                max=Math.max(max,freq);
            }
        }
        return max;
    }
}
