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
        if(count<m){
            return false;
        }

        return true;
    }

    int binary_search(int[] arr,int m,int k){

                int[] brr = arr.clone();

                Arrays.sort(brr);

                int low=0;
                int high=brr.length-1;
                int ans=high;
                while(low<=high){

                    int mid = low + (high - low) / 2;
                    if(check(arr,brr[mid],m,k)){
                        ans=mid;
                        high=mid-1;
                    }else {
                    low=mid+1;
                    }
                }
            return brr[ans];

    }
    public int minDays(int[] arr, int m, int k) {
        if ((long)m * (long)k > arr.length) {
            return -1;
        }

        else{
            return binary_search(arr,m,k);
        }
    }
}