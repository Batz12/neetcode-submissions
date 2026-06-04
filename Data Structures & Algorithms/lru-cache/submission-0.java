class LRUCache {

    public class Node {
        int key;
        int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
         if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            node.val = value;

            remove(node);
            insert(node);

            return;
        }

        Node node = new Node(key, value);

        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node lru = head.next;

            remove(lru);
            cache.remove(lru.key);
        }
    }
}
