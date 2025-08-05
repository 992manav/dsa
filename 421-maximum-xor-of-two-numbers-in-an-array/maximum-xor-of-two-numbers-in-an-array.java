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
        int xorValue = 0;

        for (char c : s.toCharArray()) {
            int bit = c - '0';
            int opposite = 1 - bit;

            if (curr.children[opposite] != null) {
                xorValue = (xorValue << 1) | 1;
                curr = curr.children[opposite];
            } else {
                xorValue = xorValue << 1;
                curr = curr.children[bit];
            }
        }

        return xorValue;
    }

    public int findMaximumXOR(int[] nums) {
        String[] binaries = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            String binary = Integer.toBinaryString(nums[i]);
            while (binary.length() < 32) binary = "0" + binary;
            binaries[i] = binary;
            insert(binary);
        }

        int max = Integer.MIN_VALUE;
        for (String binary : binaries) {
            int xor = search(binary);
            max = Math.max(xor, max);
        }

        return max;
    }
}
