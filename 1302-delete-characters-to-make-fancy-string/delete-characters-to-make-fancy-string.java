class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        
        char last = s.charAt(0);
        int count = 1;
        sb.append(last);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr != last) {
                last = curr;
                count = 0;
            }

            if (++count > 2) continue;

            sb.append(curr);
        }

        return sb.toString();
    }
}
