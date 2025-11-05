import java.util.*;

class Solution {

    public int maxFrequency(int[] nums, int k, int numOperations) {

        int n = nums.length;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            start = Math.min(start, nums[i]);
            end = Math.max(end, nums[i]);
        }

        start = start - k;
        end = end + k;

        int[] freq = new int[end - start + 1];

        int max = 0;

        for(int i=0;i<n;i++){
            int num = nums[i];
            int lef = num - k - start;
            int rig = num + k - start;

            if(lef >= 0 && lef < freq.length) freq[lef] += 1;
            if(rig + 1 >= 0 && rig + 1 < freq.length) freq[rig + 1] -=1;
        }

        for(int i=1;i<freq.length;i++){
            freq[i] = freq[i-1]+freq[i];
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(int i=0;i<freq.length;i++){
            int target = i + start;
            int target_count = 0;
            if(map.containsKey(target)){
                target_count = map.get(target);
            }

            int available = freq[i]-target_count;

            if(available > numOperations){
                int fr = numOperations + target_count;
                max = Math.max(max, fr);
            }else{
                int fr = available+target_count;
                max = Math.max(max, fr);
            }
        }

        return max;
    }
}
