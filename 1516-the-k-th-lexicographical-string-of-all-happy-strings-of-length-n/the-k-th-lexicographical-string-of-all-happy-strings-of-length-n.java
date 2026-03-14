class Solution {

    int n;
    int k;

    String fun(int i, String s) {

        if (i == n) {
            return s;
        }

        int remaining = n - i;
        int x = (int)Math.pow(2, remaining - 1);

        char last = s.charAt(s.length() - 1);

        if (last == 'a') {
            if (k <= x) {
                return fun(i + 1, s + "b");
            } else {
                k = k - x;
                return fun(i + 1, s + "c");
            }
        }

        if (last == 'b') {
            if (k <= x) {
                return fun(i + 1, s + "a");
            } else {
                k = k - x;
                return fun(i + 1, s + "c");
            }
        }

        if (k <= x) {
            return fun(i + 1, s + "a");
        } else {
            k = k - x;
            return fun(i + 1, s + "b");
        }
    }

    public String getHappyString(int n, int k) {

        this.n = n;
        this.k = k;

        int block = (int)Math.pow(2, n - 1);

        if (k > 3 * block) {
            return "";
        }

        if (k <= block) {
            return fun(1, "a");
        }

        if (k <= 2 * block) {
            this.k = k - block;
            return fun(1, "b");
        }

        this.k = k - 2 * block;
        return fun(1, "c");
    }
}