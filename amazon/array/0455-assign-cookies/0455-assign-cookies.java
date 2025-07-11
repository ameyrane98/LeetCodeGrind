class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //sort children and cookies in ascending order
        Arrays.sort(g);// increasing in greed
        Arrays.sort(s);// increasing in cookie size

        int cookieIndex=0;
        int contentChildren=0;

        while(cookieIndex<s.length && contentChildren< g.length){
            if(s[cookieIndex]>=g[contentChildren]){
                contentChildren++;
            }
            cookieIndex++;
        }
        

        return contentChildren;
    }
}