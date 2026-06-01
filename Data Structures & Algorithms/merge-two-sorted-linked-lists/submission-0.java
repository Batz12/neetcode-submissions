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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // We will create a dummy node first and use that to select the first node in the list
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                start.next = list1;
                list1 = list1.next;
            } else {
                start.next = list2;
                list2 = list2.next;
            }

            start = start.next;
        }

        if(list1 != null) {
            start.next = list1;
        } else {
            start.next = list2;
        }

        return dummy.next;
    }
}