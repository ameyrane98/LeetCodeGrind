class Solution {
    
  
    public int maxCount(int[] banned, int n, int maxSum) {
        int result=0;
        int count=0;
        HashSet<Integer> arr= new HashSet<Integer>();
        for(int i=0; i<banned.length;i++){
            if(banned[i]<=n){
                arr.add(banned[i]);
            }else{
                continue;
            }
           
        }

        
        System.out.println(arr);
        for(int j=1; j<=n;j++){
            if(arr.contains(j)){
             // number is banned
                continue;
            }
         
            if(result+j<=maxSum){
                result+=j;
                count+=1;
            }else{
                break;
            }
        }

        return count;
    }
}