class Solution {

    boolean check(int[] arr,int mid,int m,int k){
        int count=0;
        int flag=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
               flag++;
               if(flag==k){
                    count++;
                    flag=0;
               }
            }else{
                flag=0;
            }
        }
        return count >= m;
    }

    int binary_search(int[] arr,int m,int k){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int val : arr) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(arr, mid, m, k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int minDays(int[] arr, int m, int k) {
        if ((long)m * (long)k > arr.length) return -1;
        return binary_search(arr, m, k);
    }
}
