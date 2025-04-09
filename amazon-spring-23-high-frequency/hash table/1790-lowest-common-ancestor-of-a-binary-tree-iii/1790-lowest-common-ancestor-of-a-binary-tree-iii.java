/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    /**Brute Force */
//     Time: O(h) – where h = height of the tree

// Space: O(h) – for storing p's ancestors
    // public Node lowestCommonAncestor(Node p, Node q) {
    //     Set<Node> data= new HashSet();

    //     while(p!=null){
    //         data.add(p);
    //         p=p.parent;
    //     }


    //     while(q!=null){
    //         if(data.contains(q)){
    //             return q;
    //         }
    //         q=q.parent;
    //     }

    //     return null;
    // }

    /**Opitmal Approach */
    public Node lowestCommonAncestor(Node p, Node q) {
       Node a=p;
       Node b=q;

       while(a!=b){
            a=(a==null)? q:a.parent;
            b=(b==null)? p:b.parent;
       }

       return a;
    }
}