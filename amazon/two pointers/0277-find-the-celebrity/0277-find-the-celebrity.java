/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    int numberOfpeople;
    public int findCelebrity(int n) {
    numberOfpeople=n;

       for(int i=0; i<n; i++){
            if(isCeleb(i)){
                return i;
            }
       }

       return -1;
    }

    public boolean isCeleb(int c){
        for(int i=0; i<numberOfpeople; i++){
            if(i==c){
                continue;
            }
            if(knows(c,i) || !knows(i,c)){
                return false;
            }
        }

        return true;
    }

}