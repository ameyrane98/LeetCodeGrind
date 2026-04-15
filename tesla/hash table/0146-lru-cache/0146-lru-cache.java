class LRUCache {
    HashMap<Integer,Integer> hmap;
    Queue<Integer> que;
    int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        hmap=new HashMap<>();
        que= new LinkedList<>();
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
            que.remove(key);   // remove old position
            que.add(key);      // re-add at back
            hmap.put(key,value); // update value
        }else{
            if(cap==que.size()){   // cache full?
            int k = que.poll();  // remove LRU (front of queue)
            hmap.remove(k);      // delete from map
            }
            que.add(key);            // add as most recent
            hmap.put(key,value);     // insert value
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */