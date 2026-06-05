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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if(l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }

        return dummy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        while(lists.length != 1) {
            List<ListNode> mergedList = new ArrayList<ListNode>();

            for(int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];

                ListNode l2 = ((i + 1) < lists.length)? lists[i + 1] : null;

                mergedList.add(mergeTwoLists(l1, l2));
            }


            lists = mergedList.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}
