/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        int min = Integer.MAX_VALUE;
        int first_index = -1;
        int just_previous = -1;
        int index = 1;

        ListNode prev = head;
        temp = head.next; // start from the second node
        ListNode next = (temp != null) ? temp.next : null;

        while (temp != null && next != null) {
            if ((temp.val > prev.val && temp.val > next.val) || (temp.val < prev.val && temp.val < next.val)) {
                if (just_previous != -1) {
                    min = Math.min(min, index - just_previous);
                } else {
                    first_index = index;
                }
                just_previous = index;
            }

            prev = temp;
            temp = temp.next;
            next = (temp != null) ? temp.next : null;
            index++;
        }

        if (just_previous == first_index || first_index == -1) {
            return new int[]{-1, -1};
        }

        int max = just_previous - first_index;
        return new int[]{min, max};
    }
}
