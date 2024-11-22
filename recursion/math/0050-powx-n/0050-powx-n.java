class Solution {
    // public double myPow(double x, int n) {
    //     if(n==0){
    //         return 1;
    //     }
        
    //     x=x*myPow(x,Math.abs(n)-1);

    //     if(n<0){
    //         return 1/x;
    //     }

    //     return x;
    // }

     public double myPow(double x, int n) {
        // Handle edge case where n is Integer.MIN_VALUE
        long N = n; // Use long to prevent overflow
        if (N < 0) {
            x = 1 / x;  // Invert the base
            N = -N;     // Make exponent positive
        }
        
        return fastPow(x, N);
    }

     private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;  // Base case: x^0 = 1
        }
        
        double half = fastPow(x, n / 2); // Divide exponent by 2
        if (n % 2 == 0) {
            return half * half; // If n is even, result is (x^(n/2))^2
        } else {
            return half * half * x; // If n is odd, include one more x
        }
    }


}