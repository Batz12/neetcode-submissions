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
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode nextNode = head.next;

        while(nextNode != null) {
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
            nextNode = nextNode.next;
        }

        head.next = prevNode;

        return head;
    }
}
