// class LRUCache {
//     HashMap<Integer,Integer> hmap;
//     Queue<Integer> que;
//     int n;
//     public LRUCache(int capacity) {
//         hmap= new HashMap();
//         que= new LinkedList();
//         n=capacity;
//     }
    
//     public int get(int key) {
//         if(!hmap.containsKey(key)){
//             return -1;
//         }
//         que.remove(key);
//         que.add(key);
//         return hmap.get(key);
//     }
    
//     public void put(int key, int value) {
//         if(hmap.containsKey(key)){
//             que.remove(key);
//             que.add(key);
//             hmap.put(key,value);
//         }else{
//             if(n==que.size()){
//                 int k = que.poll();
//                 hmap.remove(k);
//             }

//             que.add(key);
//             hmap.put(key,value);
//         }
//     }
// }


/** Appraoch 2 using linekid list */
class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer,ListNode> dic;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        dic=new HashMap<>();
        head= new ListNode(-1, -1); //dummu head and tail 
        tail= new ListNode(-1, -1);// actual value at head.next and tai.prev
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
       if(!dic.containsKey(key)){
            return -1;
       }

       ListNode node= dic.get(key);
        remove(node);
        add(node);
       return node.val;
    }

    public void put(int key, int value) {
        if(dic.containsKey(key)){
            ListNode oldNode = dic.get(key);
            remove(oldNode);
       }

       ListNode node = new ListNode(key,value);
       dic.put(key,node);
       add(node);

       if(dic.size() > capacity){
            ListNode oldNode = head.next;// front of linked list
            remove(oldNode);
            dic.remove(oldNode.key);
       }

    }

    public void add(ListNode node){
        ListNode prevNode= tail.prev;
        prevNode.next=node;
        node.prev=prevNode;
        node.next=tail;
        tail.prev=node;
    }

    public void remove(ListNode node){
        //A<->B<->C remove B 
       
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }


}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */