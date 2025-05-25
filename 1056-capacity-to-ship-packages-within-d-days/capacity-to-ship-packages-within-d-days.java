class Solution {

    int[] find_max(int[] arr){
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int ele : arr){
            if(ele>max){
                max=ele;
            }
            sum=sum+ele;
        }
        // int[] a=new int[2];
        // a[0]=max;
        // a[1]=sum;
        // return a;

        return new int[]{max, sum};
    }


    boolean check(int[] arr, int weight, int days) {
    int sum = 0;
    int day = 1; // start with day 1

    for (int num : arr) {
        if (sum + num > weight) {
            day++;
            sum = 0;
        }
        sum += num;

        if (day > days) {
            return false;
        }
    }

    return true;
}


    int binary_search(int[] w,int days){
        int[] arr=find_max(w);
        int low=arr[0];
        int high=arr[1];
        int ans=high;
        while(low<=high){

            int mid=low + (high-low)/2;

            if(check(w,mid,days)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
    return ans;
    }


    public int shipWithinDays(int[] w, int days) {
        return binary_search(w,days);
    }
}