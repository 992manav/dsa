class Solution {
    public String convert(String s, int numRows) {
        StringBuilder a[] = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) {
            a[i] = new StringBuilder(); 
        }

        int index = 0;  
        boolean flag = false; 

        while (index < s.length()) {
            for (int i = 0; i < numRows; i++) {
                a[i].append(s.charAt(index));
                index++;
                if (index >= s.length()) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }

            for (int i = numRows - 2; i > 0; i--) { 
                a[i].append(s.charAt(index));
                index++;
                if (index >= s.length()) {
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(a[i]);
        }

        return result.toString();
    }
}
