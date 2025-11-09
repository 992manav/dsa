import java.util.*;
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {

        // step1 : prefix sum banao but +1 / -1 me convert karke
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                nums[i]=1;        // target mila toh +1
            } else {
                nums[i]=-1;       // nahi toh -1
            }
            if(i==0){
                prefix[0]=nums[0]; // first value direct
            } else {
                prefix[i]=prefix[i-1]+nums[i]; // normal prefix sum
            }
        }

        // step2 : sorted list bana rahe hai prefix store karne ke liye
        List<Integer> lst = new ArrayList<>();
        lst.add(0); // prefix = 0 base case

        long tot=0;

        // step3 : har prefix ke liye dekho pehle kitne prefix < current hai
        // l<r
        // find karo prefix[l] < prefix[r];
        // becoz we want sum > 0 of subarray ;
        // sum = prefix[r] - prefix[l];
        // prefix[r] - prefix[l] > 0;
        // prefix[r] > prefix[l];

        // jitne '< cur' utne valid majority subarrays hai
        for(int r=0;r<n;r++){
            int cur = prefix[r];

            // idx = kitne elements < cur
            int idx = lowerBound(lst, cur);

            tot+=idx;

            // cur ko correct sorted position me insert karo
            lst.add(idx, cur);
        }
        return tot;
    }

    // first index jaha element >= key ho
    // iss index se pehle wale saare < key hai
    private int lowerBound(List<Integer> a, int key){
        int low = 0;
        int high = a.size();
        int ans = a.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(a.get(mid) >= key){
                ans = mid;     // yeh ek possible answer hai
                high = mid;    // left side me aur check karo
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
