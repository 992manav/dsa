import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        int idx = s.length() - 1;
        int count = 0;

        StringBuilder sb = new StringBuilder(s);

        while (idx >= 0) {
            char last = sb.charAt(idx);
            
            if(idx==0 && last==1){
                break;
            }
            if (last == '0') {
                count++;
                idx--;
            } else {
                int temp = idx;
                int c = 1;  

                if(temp==0){
                    break;
                }

                while (temp >= 0) {
                    if (sb.charAt(temp) == '1') {
                        if (c == 0) {
                            break;
                        } else {
                            sb.setCharAt(temp, '0');
                        }
                    } else {
                        sb.setCharAt(temp, '1');
                        break;
                    }
                    temp--;
                }

                count++;
            }
        }

        return count;
    }
}