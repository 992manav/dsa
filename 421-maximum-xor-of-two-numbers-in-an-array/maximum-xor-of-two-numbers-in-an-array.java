class TrieNode {
    TrieNode[] children = new TrieNode[2];
    boolean isEow = false;
}

class Solution {
    TrieNode root = new TrieNode();

    void insert(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int index = c - '0';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEow = true;
    }

    int search(String s) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = c - '0';
            int opposite = 1 - index;

            if (curr.children[opposite] != null) {
                sb.append('1');
                curr = curr.children[opposite];
            } else {
                sb.append('0');
                curr = curr.children[index];
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            String binary = Integer.toBinaryString(num);
            while (binary.length() < 32) binary = "0" + binary;
            insert(binary);
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            String binary = Integer.toBinaryString(num);
            while (binary.length() < 32) binary = "0" + binary;
            int xor = search(binary);
            max = Math.max(xor, max);
        }

        return max;
    }
}
