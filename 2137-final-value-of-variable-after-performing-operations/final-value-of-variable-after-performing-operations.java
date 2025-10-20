class Solution {
    public int finalValueAfterOperations(String[] ops) {
        int x = 0;
        for (String op : ops) {
            char s = op.charAt(1); 
            if (s == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
