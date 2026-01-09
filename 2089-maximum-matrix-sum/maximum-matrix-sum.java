class Solution {
    public long maxMatrixSum(int[][] mat) {
        int n = mat.length;

        // negative bohot easily propagate hote hai matrix mein
        // isliye sign ka sirf overall effect matter karta hai

        long sum = 0;
        int count = 0;

        // minimum absolute value track karenge
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // agar element negative hai to count badhao
                if (mat[i][j] < 0) {
                    count++;
                }

                // sabka absolute value sum mein add kar do
                sum += Math.abs(mat[i][j]);

                // sabse chhota absolute element nikaalo
                min = Math.min(min, Math.abs(mat[i][j]));
            }
        }

        // agar negative elements even count mein hain
        // to sabko positive bana sakte hain
        if (count % 2 == 0) {
            return sum;
        }

        // warna ek element negative rehna hi padega
        // to sabse chhota absolute value wala negative rakho
        return sum - 2L * min;
    }
}
