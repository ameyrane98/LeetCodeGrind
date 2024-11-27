class Solution {
    int[] t= new int[10001];
    public boolean canJump(int[] nums) {
        Arrays.fill(t,-1);
        return canJumpSolve(nums,nums.length,0)==1 ? true : false;
    }

    int canJumpSolve(int[] nums,int n, int idx){
        if(idx==n-1){
            return 1;
        }
        if(t[idx]!=-1){
            return t[idx];
        }


        for(int i=1;i<=nums[idx];i++){
            if(canJumpSolve(nums,n,idx+i)==1){
                return t[idx]=1;
            }
        }

        return t[idx]=0;
    }
}