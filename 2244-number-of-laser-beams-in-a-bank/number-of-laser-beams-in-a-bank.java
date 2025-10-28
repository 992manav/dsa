class Solution {
    public int numberOfBeams(String[] a) {
        int prev = 0;
        int tot = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a[i].length(); j++) {
                if (a[i].charAt(j) == '1') { 
                    count++;
                }
            }

            tot += prev * count;
            if (count != 0) prev = count;
        }
        return tot;
    }
}
