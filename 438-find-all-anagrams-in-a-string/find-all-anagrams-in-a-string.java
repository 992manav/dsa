class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> lst = new ArrayList<>();
        int offset = 101;

        if (p.length() > s.length()) return lst;

        int sum = 0, xor = 0, sumSq = 0;
        for (char c : p.toCharArray()) {
            int num = (c - 'a') + offset;
            xor ^= num;
            sum += num;
            sumSq += num * num;
        }

        int i = 0, j = 0;
        int xor1 = 0, newSum = 0, newSumSq = 0;
        for (j = 0; j < p.length() - 1 && j < s.length(); j++) {
            int num = (s.charAt(j) - 'a') + offset;
            xor1 ^= num;
            newSum += num;
            newSumSq += num * num;
        }

        while (j < s.length()) {
            int num = (s.charAt(j) - 'a') + offset;
            xor1 ^= num;
            newSum += num;
            newSumSq += num * num;

            if (newSum == sum && xor1 == xor && newSumSq == sumSq) {
                lst.add(i);
            }

            num = (s.charAt(i) - 'a') + offset;
            xor1 ^= num;
            newSum -= num;
            newSumSq -= num * num;

            i++;
            j++;
        }

        return lst;
    }
}
