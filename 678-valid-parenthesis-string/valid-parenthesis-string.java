import java.util.*;

class Solution {
    public boolean checkValidString(String s) {

        Stack<Character> st = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                if(c=='('){
                    count=0;
                }
                st.push(c);

            } else if (c == ')') {
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
                    } else {
                        while (!st.isEmpty() && st.peek() == '*') {
                            count++;
                            st.pop();
                        }

                        if (st.isEmpty()) {
                            if (count == 0) {
                                return false;
                            }
                            count--;
                        } else if (st.peek() == '(') {
                            st.pop();
                        }

                        while (count-- > 0) {
                            st.push('*');
                        }
                        count = 0;
                    }
                }
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                if (count > 0) {
                    count--;
                } else {
                    return false;
                }
                st.pop();
            } else if (st.peek() == ')') {
                return false;
            } else {
                count++; // <-- added this ONLY
                st.pop();
            }
        }
        return true;
    }
}
