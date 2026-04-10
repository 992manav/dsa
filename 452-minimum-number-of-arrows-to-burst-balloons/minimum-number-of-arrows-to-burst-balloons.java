class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int l=points[0][0];
        int r=points[0][1];

        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int n=points.length;
        int count=1;
        for(int i=0;i<n;i++){
            int a=points[i][0];
            int b=points[i][1]; 


            if(a>r){
                count++;
                l=a;
                r=b;
            }else{
                l=Math.max(a,l);
                r=Math.min(b,r);
            }
        }
        
        return count;

    }
}