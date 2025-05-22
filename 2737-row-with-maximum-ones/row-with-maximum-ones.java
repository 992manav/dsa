class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int max_count=0;
        int ind=0;
        for(int i=0;i<mat.length;i++){
            int count=0;

            for(int j=0;j<mat[i].length;j++){
                count+=mat[i][j];
            }
            if(count>max_count){
                max_count=count;
                ind=i;
            }
        }
        int[] arr = new int[2];

        arr[0]=ind;
        arr[1]=max_count;
        return arr;

    }
}