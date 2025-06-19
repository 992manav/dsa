class Solution {
    public boolean lemonadeChange(int[] bills) {

        if (bills[0] != 5) {
            return false;
        }

        int fives = 1;
        int tens = 0;
        int twny = 0;
        int sum = 5;

        for (int i = 1; i < bills.length; i++) {

            if (bills[i] == 5) {
                fives++;
                sum += 5;
            } else if (bills[i] == 10) {
                if (fives >= 1) {
                    fives--;
                    sum -= 5;
                } else {
                    return false;
                }

                tens++;
                sum += 10;
            } else {

                if (sum >= 15) {

                    if (tens >= 1) {
                        tens--;
                        sum -= 10;

                        if (fives >= 1) {
                            fives -= 1;
                            sum -= 5;
                        } else {
                            return false;
                        }

                    } else {

                        if (fives >= 3) {
                            fives -= 3;
                            sum -= 15;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

                twny++;
                sum += 20;
            }
        }

        return true;
    }
}
