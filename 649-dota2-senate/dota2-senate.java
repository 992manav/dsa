class Solution {

    String fun(String s, int ignoreR, int ignoreD) {

        StringBuilder sb = new StringBuilder(s);

        int countR = 0;
        int countD = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                countR++;
            } else {
                countD++;
            }
        }

        StringBuilder next = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {

            char c = sb.charAt(i);

            if (c == 'R') {
                if (ignoreR > 0) {
                    sb.setCharAt(i, 'M');
                    countR--;
                    ignoreR--;
                } else {
                    next.append("R");
                    if (countD > 0) {
                        ignoreD++;
                    } else {
                        return "Radiant";
                    }
                }
            } else if (c == 'D') {
                if (ignoreD > 0) {
                    sb.setCharAt(i, 'M');
                    ignoreD--;
                    countD--;
                } else {
                    next.append("D");
                    if (countR > 0) {
                        ignoreR++;
                    } else {
                        return "Dire";
                    }
                }
            }
        }

        return fun(next.toString(), ignoreR, ignoreD);
    }

    public String predictPartyVictory(String senate) {
        return fun(senate, 0, 0);
    }
}
