class Solution {

    HashMap<String, Boolean> dp = new HashMap<>();

    boolean fun(int i, String s, int len, String curr, List<String> allowed) {

        if (len == 1) {
            return true;
        }

        if (i == len - 1) {
            if (dp.containsKey(curr)) {
                return dp.get(curr);
            }
            boolean res = fun(0, curr, len - 1, "", allowed);
            dp.put(curr, res);
            return res;
        }

        for (int k = 0; k < allowed.size(); k++) {
            String c = allowed.get(k);

            if (c.charAt(0) == s.charAt(i) && c.charAt(1) == s.charAt(i + 1)) {
                if (fun(i + 1, s, len, curr + c.charAt(2), allowed)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        return fun(0, bottom, bottom.length(), "", allowed);
    }
}
