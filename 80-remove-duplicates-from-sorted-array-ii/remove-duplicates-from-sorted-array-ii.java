import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0,n=nums.length;
        while(j<n){
            if(j<n-1 && nums[j]!=Integer.MAX_VALUE && nums[j+1]!=Integer.MAX_VALUE && nums[j]==nums[j+1]){
                nums[i]=nums[j];
                if(i+1<n) nums[i+1]=nums[j+1];
                if(i!=j){
                    if(j>i+1) nums[j]=Integer.MAX_VALUE;
                    if(j+1>i+1) nums[j+1]=Integer.MAX_VALUE;
                }
                i+=2; j+=2;
                while(j<n && (nums[j]==nums[i-1] || nums[j]==Integer.MAX_VALUE)) j++;
            } else {
                if(nums[j]!=Integer.MAX_VALUE) nums[i++]=nums[j];
                if(i-1!=j && j>i-1) nums[j]=Integer.MAX_VALUE;
                j++;
            }
        }
        return i;
    }
}
