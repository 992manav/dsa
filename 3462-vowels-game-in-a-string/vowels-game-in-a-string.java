class Solution {
    
    boolean check(char c) {
        
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    } 
    
    int vowels(String s) { 
        int count = 0; 
        for (char c : s.toCharArray()) { 
            if (check(c)) { 
                count++; 
            } 
        } 
        return count; 
    } 
    
    public boolean doesAliceWin(String s) { 
        int count = vowels(s); 
        if (count ==0) { 
            return false; 
        } 
        return true; 
    } 
}
