class Solution {
    int number=0;
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        if(x<9){
            return true;
        }

        if(x%10==0){
            return false;
        }
        solve(x);
        return x==number?true:false;
    }

    public int solve(int x){
        
        while(x!=0){
            int rem= x % 10;
            number=rem+number*10;
            x=x/10;
        }
        System.out.print(number);
        return number;
    }
}