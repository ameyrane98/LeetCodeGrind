/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Queue<ListNode> oddQue = new LinkedList<>();
    // Queue<ListNode> evenQue =new LinkedList<>();
    // public ListNode oddEvenList(ListNode head) {
    //     // add the od
    //     ListNode curr= head;
    //     int count=1;
    //     while(curr!=null){
    //         if(count%2==1){
    //            oddQue.offer(curr);
    //         }else{
    //            evenQue.offer(curr);
    //         }

    //         curr=curr.next;
    //         count++;
    //     }

    //     ListNode dummy= new ListNode(0);
    //     ListNode tail= dummy;
    //     while (!oddQue.isEmpty()) { tail.next = oddQue.poll(); tail = tail.next; }
    //     while (!evenQue.isEmpty()) { tail.next = evenQue.poll(); tail = tail.next; }
    //     tail.next = null; // terminate

    //     return dummy.next;
    // }


    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next== null){
            return head;
        }

        ListNode oddPtr= head;
        ListNode evenPtr= head.next;
        ListNode evenHead=evenPtr;

        while(evenPtr!=null && evenPtr.next!=null){
            oddPtr.next=evenPtr.next; //link odd
            oddPtr=oddPtr.next;
            evenPtr.next=evenPtr.next.next;// link even
            evenPtr=evenPtr.next;
        }
      
        oddPtr.next= evenHead;
        return head;
    }   
}