import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '*') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.isEmpty()) return false;

                if (st.peek() == '(') {
                    st.pop();
                } else {
                    int count = 0;

                    // Count and remove consecutive '*' from stack
                    while (!st.isEmpty() && st.peek() == '*') {
                        st.pop();
                        count++;
                    }

                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();  // match '(' with ')'
                    } else if (count > 0) {
                        count--;  // treat one '*' as '('
                    } else {
                        return false; // no matching '(' or '*'
                    }

                    // Push back remaining '*' if any
                    while (count-- > 0) {
                        st.push('*');
                    }
                }
            }
        }

        // If only '*' left, it's okay; if any unmatched '(', return false
        int starCount = 0;
        while (!st.isEmpty()) {
            if (st.pop() == '(') {
                if (starCount == 0) return false;
                starCount--; // use one '*' as ')'
            } else {
                starCount++; // count '*'
            }
        }

        return true;
    }
}
