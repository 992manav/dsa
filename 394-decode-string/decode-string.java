class Solution {

    String decode(String s, int[] i) {
        StringBuilder res = new StringBuilder();

        while (i[0] < s.length() && s.charAt(i[0]) != ']') {

            if (Character.isDigit(s.charAt(i[0]))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i[0]))) {
                    num = num * 10 + (s.charAt(i[0]) - '0');
                    i[0]++;
                }

                String inner = "";

                if (s.charAt(i[0]) == '[') {
                    i[0]++;
                    inner = decode(s, i);
                    i[0]++;
                }

                for (int k = 0; k < num; k++) {
                    res.append(inner);
                }

            } else if (s.charAt(i[0]) == '[') {
                i[0]++;
                res.append(decode(s, i));
                i[0]++;
            } else {
                res.append(s.charAt(i[0]));
                i[0]++;
            }
        }

        return res.toString();
    }

    public String decodeString(String s) {
        int[] i = new int[1];
        return decode(s, i);
    }
}
