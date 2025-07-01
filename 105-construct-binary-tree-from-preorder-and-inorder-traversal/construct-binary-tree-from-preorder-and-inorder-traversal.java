/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    // Helper function to find index of a value in inorder array between a range
    int find_index(int[] a, int target, int range_left, int range_right) {
        for (int i = range_left; i <= range_right; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Recursive function to build tree
    TreeNode build(int[] pre, int[] in, int pre_index, int max_left, int max_right, int start_index, int end_index) {
        // Base case: invalid range
        if (max_left > max_right || pre_index >= pre.length ) {
            return null;
        }

        // Create current root node from preorder array
        TreeNode root = new TreeNode(pre[pre_index]);
        int rootVal = pre[pre_index];

        // Find the root index in inorder array
        int index = find_index(in, rootVal, max_left, max_right);
        if (index == -1) {
            return null;
        }

        // Left subtree: next preorder index, and left inorder range
        root.left = build(pre, in, pre_index + 1, max_left, index - 1, start_index, start_index + (index - max_left));

        // Right subtree: calculated preorder index offset, and right inorder range
        root.right = build(pre, in, pre_index + (index - max_left + 1), index + 1, max_right, pre_index + (index - max_left + 1), end_index);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder ki first value hoti hai root of the tree

        // baaki bache hue preorder ke numbers mein yeh nahi pata chalta ki
        // kaunsa number left subtree mein hai aur kaunsa right subtree mein,
        // ya left subtree kahaan khatam hota hai aur right subtree kahaan se start hota hai

        // yeh information humein inorder sequence deta hai

        // ek baar humein root preorder ki first value se mil gaya,
        // toh hum us root ko inorder sequence mein dhoondhenge

        // inorder mein root ke left mein jo numbers aayenge,
        // woh sab us root ke left subtree ka part honge

        // aur inorder mein root ke right mein jo numbers aayenge,
        // woh sab us root ke right subtree ka part honge

        // isi tarah preorder sequence ko follow karke hum tree build karenge
        // ek ek karke preorder mein aage badhte hue node create karte jayenge

        // aur inorder sequence ki help se humein direction milta rahega
        // ki kaunsa node left subtree mein aayega aur kaunsa right subtree mein

        return build(preorder, inorder, 0, 0, inorder.length - 1, 0, preorder.length - 1);
    }
}
