class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        boolean[] res= new boolean[candies.length];
        int max=Integer.MIN_VALUE;
        Arrays.fill(res,false);
        for(int candy : candies){
            max=Math.max(max,candy);
        }

        for(int i =0; i<candies.length; i++){
            if(candies[i]+extraCandies>=max){
                res[i]=true;
            }
        }

       List<Boolean> resultList = new ArrayList<>();
        for (boolean b : res) {
            resultList.add(b);
        }

        return resultList;
    }
}