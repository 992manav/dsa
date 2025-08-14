class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (left == right) {
            return head;
        }

        ListNode temp = head;
        ListNode connect_end = null;
        int pos = 1;

        if(left!=1){
                while (temp.next != null) {
                    if (pos + 1 == left) {
                        connect_end = temp;
                        temp = temp.next;
                        pos++;
                        break;
                    }
                    pos++;
                    temp = temp.next;
                }
        }
    

        ListNode curr = temp;
        ListNode prev = null;
        ListNode front = null;

        while (curr != null) {
            if (prev != null && pos == right+1) {
                break;
            }
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
            pos++;
        }

        if (connect_end != null) {
            connect_end.next = prev;
        } else {
            head = prev;
        }

        temp.next = curr;

        return head;
    }
}
