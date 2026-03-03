class Solution {
    public char findKthBit(int n, int k) {
        String s="0";
        while(n>1){
            StringBuilder sb=new StringBuilder(s);
            sb.append('1');

            for (int i = s.length()-1; i >=0; i--) {
                sb.append((char)(s.charAt(i) ^ 1));
            }

            s=sb.toString();
            n--;
        }

        // System.out.println(s);
        return s.charAt(k-1);
    }
}