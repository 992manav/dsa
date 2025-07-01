class Solution {
    public String multiply(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        List<Integer> lst = new ArrayList<>();
        // Initialize lst with enough space
        for (int k = 0; k < num1.length() + num2.length(); k++) {
            lst.add(0);
        }

        int index = 0;
        int carry = 0;

        while (j >= 0) {
            index = num2.length() - 1 - j;
            int below = num2.charAt(j) - '0';
            carry = 0;
            i = num1.length() - 1;

            while (i >= 0) {
                int upper = num1.charAt(i) - '0';
                int mul = upper * below + carry;

                int sum = lst.get(index) + mul % 10;
                lst.set(index, sum % 10);
                lst.set(index + 1, lst.get(index + 1) + sum / 10);

                carry = mul / 10;
                index++;
                i--;
            }

            if (carry != 0) {
                lst.set(index, lst.get(index) + carry);
            }
            j--;
        }

        StringBuilder sb = new StringBuilder();

        // Remove leading zeros
        int k = lst.size() - 1;
        while (k > 0 && lst.get(k) == 0) {
            k--;
        }

        for (; k >= 0; k--) {
            sb.append(lst.get(k));
        }

        return sb.toString();
    }
}
