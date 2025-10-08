class Solution {

    public int numWaterBottles(int full, int ex) {
        int count = full;
        int empty = 0;

        while (true) {

            while (full > 0) {
                empty += full % ex;
                full = full / ex;
                count += full;
            }

            if (empty < ex) {
                break;
            }

            full = empty;
            empty = 0;
        }

        return count;
    }
}
