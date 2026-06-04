/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        Node start = head;

        while(start != null) {
            Node copy = new Node(start.val);

            copy.next = start.next;
            start.next = copy;
            start = copy.next;
        }

        start = head;

        while(start != null) {
            if(start.random != null) {
                start.next.random = start.random.next;
            }

            start = start.next.next;
        }

        // Undoing the stitched list
        Node dummy = new Node(0);
        Node curNode = dummy;
        start = head;

        while(start != null) {
            Node copy = start.next;

            start.next = copy.next;
            curNode.next = copy;
            curNode = copy;

            start = start.next;
        }

        return dummy.next;
    }
}
