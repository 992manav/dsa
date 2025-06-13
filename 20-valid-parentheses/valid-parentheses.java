import java.util.Stack;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (char c : str.toCharArray()) {

            if (!s.isEmpty() && s.peek() == '(') {
                if (c == ')') {
                    s.pop();
                    continue;
                }
                if (c == '(') {
                    s.push(c);
                    continue;
                }
            }

            if (!s.isEmpty() && s.peek() == '{') {
                if (c == '}') {
                    s.pop();
                    continue;
                }
                if (c == '{') {
                    s.push(c);
                    continue;
                }
            }

            if (!s.isEmpty() && s.peek() == '[') {
                if (c == ']') {
                    s.pop();
                    continue;
                }
                if (c == '[') {
                    s.push(c);
                    continue;
                }
            }

            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                return false;
            }
        }

        return s.isEmpty();
    }
}
