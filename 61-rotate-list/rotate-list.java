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
    public ListNode rotateRight(ListNode head, int k) { 
        if (head == null || head.next == null || k == 0) return head;

        ListNode first = head; 
        ListNode temp = head;  
        int count = 0; 

        while (temp != null) { 
            count++; 
            if (temp.next == null) { 
                temp.next = head; // Make it circular
                break; 
            } 
            temp = temp.next; 
        } 

        k = k % count; 
        int index = count - k - 1; 

        temp = head; 
        while (temp != null) { 
            if (index == 0) { 
                ListNode newHead = temp.next; 
                temp.next = null; // Break the circle
                return newHead; 
            } 
            index--; 
            temp = temp.next; 
        } 

        return head; // In case k == 0
    } 
}
