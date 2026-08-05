class MyHashMap {
    public class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Pair>[] buckets;
    private final int SIZE = 1000;

    public MyHashMap() {
        buckets = new ArrayList[SIZE];

        for(int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        for(Pair pair : buckets[index]) {
            if(pair.key == key) {
                pair.value = value;
                return;
            }
        }

        buckets[index].add(new Pair(key, value));
    }
    
    public int get(int key) {
        int index = hash(key);

        for(Pair pair : buckets[index]) {
            if(pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);

        Iterator<Pair> iterator = buckets[index].iterator();

        while(iterator.hasNext()) {
            if(iterator.next().key == key) {
                iterator.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */