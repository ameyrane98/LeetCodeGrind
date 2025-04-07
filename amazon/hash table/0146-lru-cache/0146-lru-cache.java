
class LRUCache {
    HashMap<Integer, Integer> hmap;
    Queue<Integer> que;
    int n;

    public LRUCache(int capacity) {
        hmap = new HashMap<>();
        que = new LinkedList<>();
        n = capacity;
    }

    public int get(int key) {
        if (!hmap.containsKey(key)) return -1;

        que.remove(key); // O(n), but okay for small inputs
        que.add(key);    // move to end (most recently used)
        return hmap.get(key);
    }

    public void put(int key, int value) {
        if (hmap.containsKey(key)) {
            que.remove(key);
        } else if (que.size() == n) {
            int lru = que.poll(); // remove least recently used
            hmap.remove(lru);
        }

        que.add(key);
        hmap.put(key, value);
    }
}
