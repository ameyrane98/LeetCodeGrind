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
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> data= new HashSet();

        while(p!=null){
            data.add(p);
            p=p.parent;
        }


        while(q!=null){
            if(data.contains(q)){
                return q;
            }
            q=q.parent;
        }

        return null;
    }
}