/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Node dfs(Node node, HashMap<Integer, Node> nodeMap) {
        if(node == null) {
            return null;
        }

        if(nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());
        nodeMap.put(node.val, clone);

        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, nodeMap));
        }

        return clone;
    }

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>();
        return dfs(node, nodeMap);
    }
}