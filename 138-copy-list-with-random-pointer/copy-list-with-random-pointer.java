/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node last = null;
        Node new_head = null;

        Map<Integer, Node> map = new HashMap<>();       // index -> new node
        Map<Node, Integer> map2 = new HashMap<>();       // old node -> index
        int index = 0;

        while (temp != null) {
            Node naya_node = new Node(temp.val);

            if (new_head == null) {
                new_head = naya_node;
            }

            if (last == null) {
                last = naya_node;
            } else {
                last.next = naya_node;
                last = naya_node;
            }

            map.put(index, naya_node);
            map2.put(temp, index); // moved before temp = temp.next;

            temp = temp.next;
            index++;
        }

        temp = head;
        Node temp2 = new_head;

        while (temp != null && temp2 != null) {
            if (temp.random != null) {
                int index2 = map2.get(temp.random); // FIX: get from map2 using temp.random
                Node n = map.get(index2);           // FIX: get from map using index2
                temp2.random = n;
            }

            temp = temp.next;
            temp2 = temp2.next;
        }

        return new_head;
    }
}
