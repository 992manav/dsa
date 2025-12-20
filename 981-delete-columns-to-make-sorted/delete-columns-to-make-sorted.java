import java.util.Arrays;

class Solution {
    public int minDeletionSize(String[] strs) {

        int count = 0;

        for (int j = 0; j < strs[0].length(); j++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i].charAt(j));
            }

            String s = sb.toString();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if (!sorted.equals(s)) {
                count++;
            }
        }

        return count;
    }
}
