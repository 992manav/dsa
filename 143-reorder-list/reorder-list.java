class Solution {

    ListNode reverse(ListNode curr, ListNode prev){
        if(curr == null){
            return prev;
        }
        ListNode front = curr.next;
        curr.next = prev;
        return reverse(front, curr);
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next, null); 
        slow.next = null; 

        ListNode temp1 = head;
        ListNode temp2 = head2;

        while(temp2 != null){
            ListNode front2 = temp2.next;
            temp2.next = temp1.next;
            temp1.next = temp2;
            temp1 = temp2.next;
            temp2 = front2;
        }
    }
}
