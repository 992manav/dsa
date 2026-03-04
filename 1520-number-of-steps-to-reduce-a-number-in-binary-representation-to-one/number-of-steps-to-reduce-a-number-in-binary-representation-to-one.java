import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger n = new BigInteger(s, 2);
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger zero = BigInteger.ZERO;

        int count = 0;

        while(!n.equals(one)){
            if(n.mod(two).equals(zero)){
                n = n.divide(two);
            }else{
                n = n.add(one);
            }
            count++;
        }

        return count;
    }
}