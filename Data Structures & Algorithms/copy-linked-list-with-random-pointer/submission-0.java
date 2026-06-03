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

        HashMap<Node, Node> originalToCopyMapping = new HashMap<Node, Node>();
        Node start = head;

        while(start != null) {
            originalToCopyMapping.put(start, new Node(start.val));
            start = start.next;
        }

        start = head;

        while(start != null) {
            originalToCopyMapping.get(start).next = originalToCopyMapping.get(start.next);
            originalToCopyMapping.get(start).random = originalToCopyMapping.get(start.random);
            start = start.next;
        }

        return originalToCopyMapping.get(head);
    }
}
