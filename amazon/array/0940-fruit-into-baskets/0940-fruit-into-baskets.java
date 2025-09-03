class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> counts= new HashMap<>();

        int left =0;
        int max = 0;
        for(int i=0; i<fruits.length; i++){
            counts.put(fruits[i], counts.getOrDefault(fruits[i],0)+1);
           
          
            while(counts.size()>2){
                counts.put(fruits[left],counts.get(fruits[left])-1);
                if(counts.get(fruits[left])==0){
                    counts.remove(fruits[left]);
                }
                left++;
            }
            max=Math.max(max,i-left+1);
            
        }

        return max;
    }
}