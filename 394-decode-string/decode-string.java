class Solution {

    String decode(String s, int[] i) {
        StringBuilder res = new StringBuilder();

        while (i[0] < s.length() && s.charAt(i[0]) != ']') {

            if (Character.isDigit(s.charAt(i[0]))) {
                int num = readNumber(s, i);
                String inner = readBracketString(s, i);
                appendRepeated(res, inner, num);
            } 
            else if (s.charAt(i[0]) == '[') {
                i[0]++;
                res.append(decode(s, i));
                i[0]++;
            } 
            else {
                res.append(s.charAt(i[0]));
                i[0]++;
            }
        }

        return res.toString();
    }

    int readNumber(String s, int[] i) {
        int num = 0;
        while (i[0] < s.length() && Character.isDigit(s.charAt(i[0]))) {
            num = num * 10 + (s.charAt(i[0]) - '0');
            i[0]++;
        }
        return num;
    }

    String readBracketString(String s, int[] i) {
        if (s.charAt(i[0]) == '[') {
            i[0]++;
            String inner = decode(s, i);
            i[0]++;
            return inner;
        }
        return "";
    }

    void appendRepeated(StringBuilder res, String str, int times) {
        for (int k = 0; k < times; k++) {
            res.append(str);
        }
    }

    public String decodeString(String s) {
        int[] i = new int[1];
        return decode(s, i);
    }
}
