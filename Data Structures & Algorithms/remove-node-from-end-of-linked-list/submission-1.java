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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        while(n != 0) {
            second = second.next;
            n--;
        }

        if(second == null) {
            return head.next;
        }

        while(second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;

        return head;
    }
}
