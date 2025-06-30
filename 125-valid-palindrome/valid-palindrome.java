class Solution { 
    public boolean isPalindrome(String s) { 
        s = s.toLowerCase(); 
 
        StringBuilder sb = new StringBuilder(); 
 
        for (char c : s.toCharArray()) { 
            if (Character.isLetterOrDigit(c)) { 
                sb.append(c); 
            } 
        } 
 
        int i = 0; 
        int j = sb.length() - 1;  
 
        while (i <= j) { 
            char a = sb.charAt(i); 
            char b = sb.charAt(j); 
 
            if (a != b) { 
                return false; 
            } 
 
            i++; 
            j--; 
        } 
 
        return true; 
    } 
}
