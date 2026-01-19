class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        int x=p[0][0];
        int y=p[0][1];

        int sum=0;
        for(int i=1;i<p.length;i++){
            int new_x=p[i][0];
            int new_y=p[i][1];

            int diff_x=Math.abs(new_x-x);
            int diff_y=Math.abs(new_y-y);

            // System.out.println("hi");
            // System.out.println(diff_x);
            // System.out.println(diff_y);
            

            if(diff_x<diff_y){
                sum+=(diff_x)+(diff_y-diff_x);
            }else{
                sum+=(diff_y)+(diff_x-diff_y);
            }

            // System.out.println(sum);

            x=new_x;
            y=new_y;

        }

        return sum;
    }
}