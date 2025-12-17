class Solution {
    public int countCollisions(String s) {

        int collision = 0;

        for (int i = 0; i < s.length(); ) {

            char c = s.charAt(i);

            if (c == 'R') {
                int j = i;
                int count = 0;

                while (j < s.length() && s.charAt(j) == 'R') {
                    j++;
                    count++;
                }

                if (j < s.length()) {
                    char next = s.charAt(j);

                    if (next == 'S') {
                        collision += count;

                    } else if (next == 'L') {
                        collision += count + 1;

                        j++;

                        while (j < s.length() && s.charAt(j) == 'S') {
                            j++;
                        }

                        int cnt = 0;
                        while (j < s.length() && s.charAt(j) == 'L') {
                            cnt++;
                            j++;
                        }

                        collision += cnt;
                    }
                }

                i = j;

            } else if (c == 'S') {
                int j = i;

                while (j < s.length() && s.charAt(j) == 'S') {
                    j++;
                }

                int count = 0;
                while (j < s.length() && s.charAt(j) == 'L') {
                    count++;
                    j++;
                }

                collision += count;
                i = j;

            } else {
                i++;
            }
        }

        return collision;
    }
}
