class Solution {

    int calculate_done(int[] arr,int mid){
        int x=arr[mid]-1;
        x=x-mid;
        return x;
    }


    int binary_search(int[] arr,int low,int high,int k){

        if(k<arr[0]){
            return k;
        }

        int ans=high+1;
        while(low<=high){
            int mid=(low+high)/2;
            int nums_missing=calculate_done(arr,mid);

            if(nums_missing<k){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }

        }
        
        ans=ans-1;
        int x=calculate_done(arr,ans);
        x=k-x;
        return arr[ans]+x;
        
    
    }

    public int findKthPositive(int[] arr, int k) {
       return binary_search(arr,0,arr.length-1,k);
    }
}
