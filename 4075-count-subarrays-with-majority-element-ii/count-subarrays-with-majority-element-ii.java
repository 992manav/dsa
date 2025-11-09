import java.util.*;
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                nums[i]=1;
            } else {
                nums[i]=-1;
            }
            if(i==0){
                prefix[0]=nums[0];
            } else {
                prefix[i]=prefix[i-1]+nums[i];
            }
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        long tot=0;
        for(int r=0;r<n;r++){
            int cur = prefix[r];
            int idx = lowerBound(lst, cur);
            tot+=idx;
            lst.add(idx, cur);
        }
        return tot;
    }
    private int lowerBound(List<Integer> a, int key){
        int low = 0;
        int high = a.size();
        int ans = a.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(a.get(mid) >= key){
                ans = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
