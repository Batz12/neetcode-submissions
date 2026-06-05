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
    private ListNode getKthNode(ListNode start, int k) {
        while(start != null && k != 0) {
            start = start.next;
            k--;
        }

        return start;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while(true) {
            ListNode kthNode = getKthNode(prevGroup, k);
            if(kthNode == null) {
                break;
            }

            ListNode nextGroup = kthNode.next;

            // Reverse group logic
            ListNode prev = nextGroup;
            ListNode cur = prevGroup.next;

            while(cur != nextGroup) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            // Reconnect the group to the list
            ListNode temp = prevGroup.next;
            prevGroup.next = kthNode;
            prevGroup = temp;
        }

        return dummy.next;
    }
}
