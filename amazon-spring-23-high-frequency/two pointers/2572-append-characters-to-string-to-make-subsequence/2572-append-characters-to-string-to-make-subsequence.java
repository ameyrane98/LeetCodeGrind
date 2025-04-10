class Solution {
    public int appendCharacters(String s, String t) {
        // check subsquence to see if any susbesquence is presnte in s whihc is alayas o subs eunce in t
        // find the maxmium subsquence lenght that is presnte in s which is alkso a susbwunec in t;
        // return t.lenght()-maxmium subsquence lenght

        int i=0; 
        int j=0; 
        int count=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                count++;
                 j++;
            }
            i++;
           

        }

        return t.length()-count;
    }
}