import java.util.*;

class Solution {

    /*
     MAIN IDEA (VERY IMPORTANT):

     Alternating string ma adjacent characters same nathi hova joie.
     Jya jya "AA" ya "BB" aave, tya ek character delete karvo pade.

     Etle:
     Minimum deletions = number of adjacent equal character pairs
    */

    // seg[index] = aa segment ma ketla jagya e "AA" ya "BB" che
    // Matlab: aa segment ne alternating banava mate ketla deletions joie
    int[] seg;

    // first[index] = aa segment no pehlo character
    // last[index]  = aa segment no chhelo character
    //
    // Kem joie?
    // Query time ek substring ek node ma nathi maltu,
    // e tukda tukda (multiple segments) ma male che.
    // Tya boundary par "AA" bane che ke nahi e check karva mate
    // first ane last jaruri che.
    char[] first;
    char[] last;

    int n;

    // ans = current query mate final deletions count
    int ans;

    // common_point = pichhla processed segment no last character
    //
    // Kem joie?
    // Segment tree left side no segment process kari lidho,
    // ane right side start karta pahela,
    // bech ma "AA" bane che ke nahi e check karvu pade.
    char common_point;

    // taken = pehlo valid segment already process thayo che ke nahi
    //
    // Kem joie?
    // Pehla segment mate koi pichhla segment nathi,
    // etle boundary check nathi karvo.
    boolean taken;

    // ================= BUILD =================
    void build(int index, int l, int r, char[] s) {

        // Single character:
        // ek character ma adjacent pair hoy j nahi
        if (l == r) {
            first[index] = s[l];
            last[index] = s[l];
            seg[index] = 0;
            return;
        }

        int mid = (l + r) / 2;

        int left_child_index = 2 * index;
        int right_child_index = 2 * index + 1;

        // Pehla left ane right parts banavo
        build(left_child_index, l, mid, s);
        build(right_child_index, mid + 1, r, s);

        // Pura segment no first character
        // left segment no first j hoy
        first[index] = first[left_child_index];

        // Pura segment no last character
        // right segment no last j hoy
        last[index] = last[right_child_index];

        // Andar na bad pairs
        seg[index] = seg[left_child_index] + seg[right_child_index];

        // IMPORTANT:
        // Left segment no last ane right segment no first
        // jo same hoy → "AA" ya "BB"
        // etle ek extra deletion lagse
        if (last[left_child_index] == first[right_child_index]) {
            seg[index]++;
        }
    }

    // ================= UPDATE =================
    void update(int index, int l, int r, int pos) {

        // Actual character change thaya vali jagya
        if (l == r) {

            // A → B or B → A
            // Ek character ma bad pair hota j nathi
            first[index] = last[index] = (first[index] == 'A') ? 'B' : 'A';
            seg[index] = 0;
            return;
        }

        int mid = (l + r) / 2;

        int left_child_index = 2 * index;
        int right_child_index = 2 * index + 1;

        // Jya update karvo che tya jao
        if (pos <= mid) {
            update(left_child_index, l, mid, pos);
        } else {
            update(right_child_index, mid + 1, r, pos);
        }

        // Update pachi current segment ne
        // pacho build jevu merge karo
        first[index] = first[left_child_index];
        last[index] = last[right_child_index];

        seg[index] = seg[left_child_index] + seg[right_child_index];
        if (last[left_child_index] == first[right_child_index]) {
            seg[index]++;
        }
    }

    // ================= QUERY =================
    void query(int index, int l, int r, int ql, int qr) {

        // Bilkul overlap nathi
        if (l > qr || r < ql) return;

        // Aa segment puri rite range ma che
        if (l >= ql && r <= qr) {

            // Pehlo segment
            // direct value lai lo
            if (!taken) {
                ans = seg[index];
                common_point = last[index];
                taken = true;
            }
            // Bija segments
            else {

                // Boundary check:
                // pichhla segment no last
                // ane aa segment no first
                // jo same hoy → ek deletion
                if (common_point == first[index]) {
                    ans++;
                }

                // Andar na bad pairs add karo
                ans += seg[index];

                // Aa segment no last yaad rakho
                // next segment mate
                common_point = last[index];
            }
            return;
        }

        // Partial overlap → left ane right banne side check
        int mid = (l + r) / 2;

        query(2 * index, l, mid, ql, qr);
        query(2 * index + 1, mid + 1, r, ql, qr);
    }

    // ================= MAIN =================
    public int[] minDeletions(String s, int[][] queries) {

        n = s.length();

        seg = new int[4 * n];
        first = new char[4 * n];
        last = new char[4 * n];

        // Segment tree tayar karo
        build(1, 0, n - 1, s.toCharArray());

        ArrayList<Integer> res = new ArrayList<>();

        for (int[] q : queries) {

            // Type 1 → update
            if (q[0] == 1) {
                update(1, 0, n - 1, q[1]);
            }
            // Type 2 → query
            else {
                ans = 0;
                taken = false;
                query(1, 0, n - 1, q[1], q[2]);
                res.add(ans);
            }
        }

        int[] out = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}
