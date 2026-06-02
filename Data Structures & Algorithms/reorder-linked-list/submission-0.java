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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        // Finding mid point
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l2 = slow.next;
        slow.next = null;

        // Reversing l2 list
        ListNode prevNode = null;

        while(l2 != null) {
            ListNode temp = l2.next;
            l2.next = prevNode;
            prevNode = l2;
            l2 = temp;
        }

        l2 = prevNode;

        // Stitching together the lists (l1 will be the longer list)
        ListNode l1 = head;
        
        while(l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l2.next = temp1;

            l1 = temp1;
            l2 = temp2;
        }
    }
}
