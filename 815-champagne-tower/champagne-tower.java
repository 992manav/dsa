class Solution {
    double[][] mat;
    int query_row;
    int query_glass;

    double fun(int r){

        int n = r + 1;
        int next_row = r + 1;

        for(int j = 0; j < n; j++){
            double kitni_hai = mat[r][j];

            if(kitni_hai < 1){
                continue;
            }

            kitni_hai -= 1;

            mat[next_row][j] += kitni_hai / 2;
            mat[next_row][j + 1] += kitni_hai / 2;
        }

        if(r == query_row){
            return Math.min(1, mat[r][query_glass]);
        }

        return fun(r + 1);
    }

    public double champagneTower(int p, int query_row, int query_glass) {

        mat = new double[101][101];
        this.query_row = query_row;
        this.query_glass = query_glass;

        mat[0][0] = p;

        return fun(0);
    }
}
