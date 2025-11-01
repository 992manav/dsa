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
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

      
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = head;
        ListNode prev = dummy;

        while (temp != null) {
            int v = temp.val;
            if (set.contains(v)) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}
