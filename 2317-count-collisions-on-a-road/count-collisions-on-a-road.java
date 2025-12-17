class Solution {

    int moveSame(String s, int j, char c) {
        while (j < s.length() && s.charAt(j) == c) {
            j++;
        }
        return j;
    }

    int countLeft(String s, int j) {
        int count = 0;
        while (j < s.length() && s.charAt(j) == 'L') {
            count++;
            j++;
        }
        return count;
    }

    public int countCollisions(String s) {

        int collision = 0;

        for (int i = 0; i < s.length(); ) {

            char c = s.charAt(i);

            if (c == 'R') {

                int j = i;
                j = moveSame(s, j, 'R');
                int count = j - i;

                if (j < s.length()) {
                    char next = s.charAt(j);

                    if (next == 'S') {
                        collision += count;
                    } 
                    else if (next == 'L') {
                        collision += count + 1;
                        j++;
                        int cnt = countLeft(s, j);
                        collision += cnt;
                        j = j + cnt;
                    }
                }
                i = j;

            } 
            else if (c == 'S') {

                int j = i;
                j = moveSame(s, j, 'S');
                int count = countLeft(s, j);
                collision += count;
                i = j + count;

            } 
            else {
                i++;
            }
        }

        return collision;
    }
}
