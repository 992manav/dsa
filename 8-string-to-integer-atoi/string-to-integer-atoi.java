class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        
        int sign = 1;
        int startIdx = 0;
        
        // Handle sign
        if (s.charAt(0) == '-') {
            sign = -1;
            startIdx = 1;
        } else if (s.charAt(0) == '+') {
            startIdx = 1;
        }
        
        // Skip leading zeros
        while (startIdx < s.length() && s.charAt(startIdx) == '0') {
            startIdx++;
        }
        
        int c = 1;
        long num = 0; // Use long to safely detect overflow
        
        // Find the end of valid digits (first non-digit after startIdx)
        int endIdx = s.length() - 1;
        for (int i = startIdx; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                endIdx = i - 1;
                break;
            }
        }
        
        // If no valid digits found, return 0
        if (endIdx < startIdx) {
            return 0;
        }
        
        for (int i = endIdx; i >= startIdx; i--) {
            
            int digit = s.charAt(i) - '0';
            long add = (long)digit * c;
             num += add;
            // Check for overflow before adding
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -(num) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            // Prevent overflow in c for next iteration
            if (c > (long)Integer.MAX_VALUE / 10) {
                // If we reach here, we've successfully processed current digit
                // but c would overflow for next iteration
                
                // Check if there are more digits to process
                boolean hasMoreDigits = (i - 1 >= startIdx);
                if (hasMoreDigits) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    return (int)(num * sign);
                }
            }
            
           
            c *= 10;
        }
        
        return (int)(num * sign);
    }
}