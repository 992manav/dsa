class Solution {

    public String countAndSay(int n) {
        String s="1";
        while(n!=1){

            StringBuilder sb = new StringBuilder();
            int count = 1;
            int i;

            for (i = 1; i < s.length(); i++) {

                if (s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(count);
                    sb.append(s.charAt(i - 1)); 
                    count = 1;
                } else {
                    count++;
                }
            }

            sb.append(count);
            sb.append(s.charAt(i - 1));

            s=sb.toString();
            n--;

        }

        return s;
    }
}
