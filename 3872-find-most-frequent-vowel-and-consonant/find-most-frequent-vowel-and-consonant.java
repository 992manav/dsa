class Solution { 
    public int maxFreqSum(String s) { 
 
        int[] freq = new int[26]; 
 
        for (char c : s.toCharArray()) { 
            freq[c - 'a']++; 
        } 
 
        int max1 = 0; 
        int max2 = 0; 
 
        for (int i = 0; i < freq.length; i++) { 
            if (check(i)) { 
                max1 = Math.max(freq[i], max1); 
            } else { 
                max2 = Math.max(freq[i], max2); 
            } 
        } 
 
        return max1 + max2; 
    } 

    boolean check(int i) {
        char c = (char) (i + 'a');
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

}
