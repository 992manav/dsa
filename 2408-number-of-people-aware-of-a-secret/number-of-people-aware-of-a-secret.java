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
    Queue<Pair> shareQueue = new LinkedList<>();
    Queue<Pair> forgetQueue = new LinkedList<>();

    void addNewPeople(int num, int currDay, int delay) {
        num %= MOD;
        // ye log currDay + forget pe bhool jayenge
        forgetQueue.add(new Pair(num, currDay + forget));
        // ye log currDay + delay se share karna start karenge
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
        int availableSharers = 0;     // jo abhi share kar rahe hain
        int totalKnowSecret = 1;      // Day 1 par ek banda secret jaanta hai ✅

        // Day1 par ek banda secret jaan gaya
        addNewPeople(1, 1, delay);

        for (int day = 2; day <= n; day++) {
            // \U0001f525 jo log bhool gaye unhe sharers aur totalKnowSecret dono me se minus karo
            int forgotToday = getForgot(day);
            availableSharers = (availableSharers - forgotToday + MOD) % MOD;
            totalKnowSecret = (totalKnowSecret - forgotToday + MOD) % MOD;

            // jo naye sharers ban gaye unhe add karo
            availableSharers = (availableSharers + getSharers(day)) % MOD;

            // jitne sharers hain utne naye log secret jaanenge
            totalKnowSecret = (totalKnowSecret + availableSharers) % MOD;

            // sharers > 0 hone par unhe queue me daal do
            if (availableSharers != 0) {
                addNewPeople(availableSharers, day, delay);
            }
        }

        return totalKnowSecret % MOD;
    }
}
