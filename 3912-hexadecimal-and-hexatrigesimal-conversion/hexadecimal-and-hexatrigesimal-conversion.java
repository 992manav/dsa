class Solution {

    char convert(int n){
        if(n <= 9){
            return (char)(n + '0');
        } else {
            n = n - 10;
            return (char)(n + 'A');
        }
    }

    String fun(int n, StringBuilder sb, int d){
        if(n == 0){
            return sb.reverse().toString();
        }
        int r = n % d;
        char c = convert(r);
        sb.append(c);
        return fun(n / d, sb, d);
    }

    public String concatHex36(int n) {
        String a = fun(n*n, new StringBuilder(), 16);
        String b = fun(n*n*n, new StringBuilder(), 36);
        return a + b;
    }
}
