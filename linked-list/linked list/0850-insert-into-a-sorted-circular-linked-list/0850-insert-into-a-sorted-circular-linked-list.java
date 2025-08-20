/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    /**
     * 
        a circular list would be a list  points to itself
        if list is empty we can point the list element to itself
     * @param head
     * @param insertVal
     * @return
     */


    public Node insert(Node head, int insertVal) {
       if(head==null){
            Node newHead= new Node(insertVal, null);
            newHead.next=newHead;
            return newHead;
       }

        Node curr = head;

        while(true){
            Node next = curr.next;

            if(curr.val<= insertVal && insertVal<=next.val ){
                break;
            }

            if(curr.val> next.val){
                if(insertVal>=curr.val || insertVal<=next.val){
                    break;
                }
            }

            curr=curr.next;

            if(curr==head){
                break;
            }
        }

        Node newNode = new Node(insertVal, curr.next);
        curr.next=newNode;

        return head;
    }


}