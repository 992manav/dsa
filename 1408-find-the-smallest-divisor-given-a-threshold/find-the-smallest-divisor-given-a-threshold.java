class Solution {

    int calculate_sum(int[] nums, int x) {
        int sum = 0;

        for (int num : nums) {
            sum = sum + (int) Math.ceil((double) num / x);
        }
        return sum;
    }

    int find_max(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    int binary_search(int[] nums, int target) {

        int low = 1;
        int high = find_max(nums);
        int ans = 0;
        int mid = 0; 
        int max_sum=Integer.MIN_VALUE;
        while (low <= high) {

            mid = (low + high) / 2;

            int sum = calculate_sum(nums, mid);

            if (sum <= target) {
                
                if(sum>=max_sum){
                    if(sum==max_sum){
                        if(mid<ans){
                            ans = mid;
                        }
                    }else{
                        max_sum=sum;
                        ans = mid;
                    }                    
                }
                
                high = mid - 1;
                
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        return binary_search(nums, threshold);
    }
}
