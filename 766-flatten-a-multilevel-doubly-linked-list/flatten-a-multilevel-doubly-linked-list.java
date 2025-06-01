/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flat(Node left, Node child, Node right) {
        if (child == null) return null;

        // Connect child to left
        if (left != null) child.prev = left;

        Node temp = child;

        while (temp != null) {
            if (temp.child != null) {
                Node nextNode = temp.next;
                Node flattenedChild = flat(temp, temp.child, nextNode);

                // Connect temp to its child head
                temp.next = flattenedChild;
                flattenedChild.prev = temp;

                temp.child = null;
            }

            if (temp.next == null) break;
            temp = temp.next;
        }

        // Connect tail of flattened child list to right
        if (right != null) {
            temp.next = right;
            right.prev = temp;
        }

        return child;
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        return flat(null, head, null);
    }
}
