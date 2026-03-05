class Solution {
    
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        int count = 0;

        int last='0';
        if(last!=arr[0]){
            count++;
        }
        for(int i = 1; i < arr.length; i++) {
            if(arr[i]==last) {
                count++;
                last=arr[i]^1;
            }else{
                last=arr[i];
            }
        }


        last='1';
        int count1=0;
        if(last!=arr[0]){
            count1++;
        }
        for(int i = 1; i < arr.length; i++) {
            if(arr[i]==last) {
                count1++;
                last=arr[i]^1;
            }else{
                last=arr[i];
            }
        }

        return Math.min(count,count1);
    }
}