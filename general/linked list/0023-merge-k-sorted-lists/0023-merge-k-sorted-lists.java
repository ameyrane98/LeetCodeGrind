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
    public ListNode mergeKLists(ListNode[] lists) {
       int k =lists.length;
        if(k==0){
            return null;
       }

        return divide(lists,0,k-1);
    }

    public ListNode divide(ListNode[] lists, int l, int r){
        if(l>r){
            return null;
        }
        if(l==r){
            return lists[l];
        }

        int mid= l+(r-l)/2;

        ListNode L1= divide(lists, l, mid);
        ListNode L2= divide(lists, mid+1, r);

        return mergeList(L1,L2);
    }

    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

       
        if(l1.val<l2.val){
                l1.next=mergeList(l1.next,l2);
                return l1;
            }else{
                l2.next=mergeList(l1,l2.next);
                return l2;
            }

    }
}