class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor=0;
        int n=nums1.length;
        int m=nums2.length;

        if(m%2!=0){
            for(int i=0;i<nums1.length;i++){
                xor=xor^nums1[i];
            }
        }


        if(n%2!=0){
            for(int i=0;i<nums2.length;i++){
                xor=xor^nums2[i];
            }
        }

        return xor;
    }
}