class Solution {
    public String multiply(String num1, String num2) {
        // Edge case optimization
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        // Using array instead of List<Integer> for better performance
        int[] lst = new int[len1 + len2];

        int j = len2 - 1;
        while (j >= 0) {
            int index = len2 - 1 - j;
            int below = num2.charAt(j) - '0';
            int carry = 0;
            int i = len1 - 1;

            while (i >= 0) {
                int upper = num1.charAt(i) - '0';
                int mul = upper * below + carry;

                int sum = lst[index] + (mul % 10);
                lst[index] = sum % 10;
                lst[index + 1] += sum / 10;

                carry = mul / 10;
                index++;
                i--;
            }

            if (carry != 0) {
                lst[index] += carry;
            }
            j--;
        }

        // Build final result string
        StringBuilder sb = new StringBuilder();
        int k = lst.length - 1;

        // Skip leading zeros
        while (k > 0 && lst[k] == 0) {
            k--;
        }

        while (k >= 0) {
            sb.append(lst[k--]);
        }

        return sb.toString();
    }
}
