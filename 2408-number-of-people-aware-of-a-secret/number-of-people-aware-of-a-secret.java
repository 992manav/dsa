import java.util.*;

class Pair {
    int num;
    int day;

    Pair(int n, int d) {
        num = n;
        day = d;
    }
}

class Solution {
    int forget;
    static final int MOD = 1000000007;
    Queue<Pair> shareQueue = new ArrayDeque<>();
    Queue<Pair> forgetQueue = new ArrayDeque<>();

    void addNewPeople(int num, int currDay, int delay) {
        num %= MOD;
        forgetQueue.add(new Pair(num, currDay + forget));
        shareQueue.add(new Pair(num, currDay + delay));
    }

    int getSharers(int day) {
        int count = 0;
        while (!shareQueue.isEmpty() && shareQueue.peek().day == day) {
            count = (count + shareQueue.remove().num) % MOD;
        }
        return count;
    }

    int getForgot(int day) {
        int count = 0;
        while (!forgetQueue.isEmpty() && forgetQueue.peek().day == day) {
            count = (count + forgetQueue.remove().num) % MOD;
        }
        return count;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        this.forget = forget;
        int availableSharers = 0;
        int totalKnowSecret = 1;

        addNewPeople(1, 1, delay);

        for (int day = 2; day <= n; day++) {
            int forgotToday = getForgot(day);
            availableSharers = (availableSharers - forgotToday + MOD) % MOD;
            totalKnowSecret = (totalKnowSecret - forgotToday + MOD) % MOD;

            availableSharers = (availableSharers + getSharers(day)) % MOD;
            totalKnowSecret = (totalKnowSecret + availableSharers) % MOD;

            if (availableSharers != 0) {
                addNewPeople(availableSharers, day, delay);
            }
        }

        return totalKnowSecret % MOD;
    }
}
