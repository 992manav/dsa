class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0"; // Optimization: shortcut for zero

        int len1 = num1.length();
        int len2 = num2.length();

        List<Integer> lst = new ArrayList<>();
        for (int k = 0; k < len1 + len2; k++) {
            lst.add(0);
        }

        for (int j = len2 - 1; j >= 0; j--) {
            int index = len2 - 1 - j;
            int below = num2.charAt(j) - '0';
            int carry = 0;
            int i = len1 - 1;

            while (i >= 0) {
                int upper = num1.charAt(i) - '0';
                int mul = upper * below + carry;

                int sum = lst.get(index) + (mul % 10);
                lst.set(index, sum % 10);
                lst.set(index + 1, lst.get(index + 1) + sum / 10);

                carry = mul / 10;
                index++;
                i--;
            }

            if (carry != 0) {
                lst.set(index, lst.get(index) + carry);
            }
        }

        StringBuilder sb = new StringBuilder();

        int k = lst.size() - 1;
        while (k > 0 && lst.get(k) == 0) k--;

        while (k >= 0) sb.append(lst.get(k--));

        return sb.toString();
    }
}
