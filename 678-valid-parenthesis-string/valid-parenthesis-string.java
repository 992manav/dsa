import java.util.*;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '*') {
                if (c == '(') {
                    count = 0;
                }
                st.push(c);
            } else { // c == ')'
                if (st.isEmpty()) {
                    if (count > 0) {
                        count--;
                    } else {
                        return false;
                    }
                } else {
                    char top = st.peek();
                    
                    if (top == '(') {
                        st.pop();
                    } else { // top == '*'
                        while (!st.isEmpty() && st.peek() == '*') {
                            count++;
                            st.pop();
                        }
                        
                        if (st.isEmpty()) {
                            if (count == 0) {
                                return false;
                            }
                            count--;
                        } else { // st.peek() == '('
                            st.pop();
                        }
                        
                        while (count > 0) {
                            st.push('*');
                            count--;
                        }
                    }
                }
            }
        }

        // Final validation
        while (!st.isEmpty()) {
            char top = st.pop();
            if (top == '(') {
                if (count > 0) {
                    count--;
                } else {
                    return false;
                }
            } else if (top == ')') {
                return false;
            } else { // top == '*'
                count++;
            }
        }
        
        return true;
    }
}