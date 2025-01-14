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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
          

        /***Iterative Approach */
        //    ListNode dummy = new ListNode(-1);
        // ListNode current = dummy;

        // // Traverse both lists and add the smaller value to the merged list
        // while (list1 != null && list2 != null) {
        //     if (list1.val < list2.val) {
        //         current.next = list1;
        //         list1 = list1.next;
        //     } else {
        //         current.next = list2;
        //         list2 = list2.next;
        //     }
        //     current = current.next;
        // }

        // // If one of the lists is not empty, append the rest of the nodes
        // if (list1 != null) {
        //     current.next = list1;
        // } else {
        //     current.next = list2;
        // }

        // // Return the merged list, which starts from dummy.next
        // return dummy.next;
     
    }
}