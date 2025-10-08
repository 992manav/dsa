class Solution {
    public int maxBottlesDrunk(int full, int ex) {
        int count = full;
        int empty = full;
        full = 0;

        while (empty >= ex) {
            empty -= ex;
            full = 1;
            count += full;
            empty += full;
            ex++;
            full = 0;
        }

        return count;
    }
}
