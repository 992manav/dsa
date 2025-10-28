class Solution {
    public int totalMoney(int divas) {   // divas = number of days
        int saptaah = divas / 7;         // saptaah = number of full weeks

        int madhya = saptaah + 3;        // madhya = middle value for formula
        int kulRakam = 0;                // kulRakam = total amount

        if (saptaah > 0) {
            kulRakam = 7 * madhya * (madhya + 1) / 2 - 42;
        }

        int bakiDivas = divas % 7;       // bakiDivas = remaining days

        int sharuRakam = saptaah + 1;    // sharuRakam = starting amount of next week

        int extraRakam = 0;              // extraRakam = leftover week money
        for (int i = 0; i < bakiDivas; i++) {
            extraRakam += sharuRakam;
            sharuRakam++;
        }

        return kulRakam + extraRakam;
    }
}
