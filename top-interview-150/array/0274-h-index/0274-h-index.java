class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] paper= new int[n+1];
        Arrays.fill(paper,0);
        for(int c: citations){
            if(c>n){
                paper[n]+=1;
            }else{
                paper[c] += 1;
            }
        }

        int h=n; // max hindex
        int cumulativePapers = 0;
        while(h>=0){
            cumulativePapers+=paper[h];
            if(cumulativePapers>=h){
                return h;
            }
            h--;
        }

     
        System.out.println(Arrays.toString(paper));
        return 0;
    }
}