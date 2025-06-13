import java.util.Stack;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (char c : str.toCharArray()) {
            switch (c) {
                case '(': case '{': case '[':
                    s.push(c);
                    break;
                case ')':
                    if (s.isEmpty() || s.pop() != '(') return false;
                    break;
                case '}':
                    if (s.isEmpty() || s.pop() != '{') return false;
                    break;
                case ']':
                    if (s.isEmpty() || s.pop() != '[') return false;
                    break;
                default:
                    return false; // optional, in case of invalid chars
            }
        }

        return s.isEmpty();
    }
}
