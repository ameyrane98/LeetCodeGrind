class LRUCache {
    HashMap<Integer,Integer> hmap;
    Queue<Integer> que;
    int n;
    public LRUCache(int capacity) {
        hmap= new HashMap();
        que= new LinkedList();
        n=capacity;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key)){
            return -1;
        }
        que.remove(key);
        que.add(key);
        return hmap.get(key);
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            que.remove(key);
            que.add(key);
            hmap.put(key,value);
        }else{
            if(n==que.size()){
                int k = que.poll();
                hmap.remove(k);
            }
            que.add(key);
            hmap.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */