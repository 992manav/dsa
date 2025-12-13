import java.util.*;

class Coupon implements Comparable<Coupon> {
    String code;
    String bl;

    @Override
    public int compareTo(Coupon other) {
        List<String> order = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

        int thisIndex = order.indexOf(this.bl);
        int otherIndex = order.indexOf(other.bl);

        if (thisIndex != otherIndex) {
            return thisIndex - otherIndex;
        }

        return this.code.compareTo(other.code); // Tie-breaker by code
    }
}

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> lst = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]) {
                String c = code[i];
                boolean valid = true;

                if (c != null && !c.isEmpty()) {
                    for (char ch : c.toCharArray()) {
                        if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        String bl = businessLine[i];
                        if (bl.equals("electronics") || bl.equals("grocery") || bl.equals("pharmacy") || bl.equals("restaurant")) {
                            Coupon obj = new Coupon();
                            obj.code = c;
                            obj.bl = bl;
                            lst.add(obj);
                        }
                    }
                }
            }
        }

        Collections.sort(lst); // Now using natural ordering from Comparable

        List<String> res = new ArrayList<>();
        for (Coupon obj : lst) {
            res.add(obj.code);
        }

        return res;
    }
}
