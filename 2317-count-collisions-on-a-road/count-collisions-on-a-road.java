class Solution {

    // j se aage same character (R ya S) jab tak milta rahe, index aage badhao
    int moveSame(String s, int j, char c) {
        while (j < s.length() && s.charAt(j) == c) {
            j++;
        }
        return j;
    }

    // j se continuous L kitne hain, sirf count return karta hai
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

            // ================= CASE 1: 'R' =================
            if (c == 'R') {

                // continuous R pakad lo (R, RR, RRR ...)
                int j = i;
                j = moveSame(s, j, 'R');
                int count = j - i;   // kitne R the

                // agar R ke baad kuch hai
                if (j < s.length()) {
                    char next = s.charAt(j);

                    // ---------- CASE: R...S ----------
                    // har R, S se takra ke 1 collision karega
                    if (next == 'S') {
                        collision += count;
                    }

                    // ---------- CASE: R...L ----------
                    // pehla collision R-L se (2 cars → +1 extra)
                    // baaki R bhi ruk jaate hain
                    else if (next == 'L') {
                        collision += count + 1;

                        // L ke baad agar S aaye toh skip
                        j++;

                        // LLL jitne honge sab S se takraenge
                        int cnt = countLeft(s, j);
                        collision += cnt;

                        j = j + cnt;
                    }
                }

                i = j;
            }

            // ================= CASE 2: 'S' =================
            else if (c == 'S') {

                int j = i;

                // continuous S skip
                j = moveSame(s, j, 'S');

                // S ke baad jitne L aayenge sab collision karenge
                int count = countLeft(s, j);
                collision += count;

                i = j + count;
            }

            // ================= CASE 3: 'L' =================
            // akela L kisi se takrata nahi
            else {
                i++;
            }
        }

        return collision;
    }
}
