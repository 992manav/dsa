class Bank {

    int n;
    long[] bal;

    public Bank(long[] bal) {
        n = bal.length;
        this.bal = new long[n];
        for (int i = 0; i < n; i++) {
            this.bal[i] = bal[i];
        }
    }

    boolean check1(int num) {
        if (num <= n && num > 0) {
            return true;
        }
        return false;
    }

    boolean check2(long mon, int no) {
        if (mon <= bal[no - 1]) {
            return true;
        }
        return false;
    }

    public boolean transfer(int acc1, int acc2, long mon) {
        if (check1(acc1) && check1(acc2) && check2(mon, acc1)) {
            bal[acc1 - 1] -= mon;
            bal[acc2 - 1] += mon;
            return true;
        }
        return false;
    }

    public boolean deposit(int acc, long mon) {
        if (check1(acc)) {
            bal[acc - 1] += mon;
            return true;
        }
        return false;
    }

    public boolean withdraw(int acc, long mon) {
        if (check1(acc) && check2(mon, acc)) {
            bal[acc - 1] -= mon;
            return true;
        }
        return false;
    }
}
