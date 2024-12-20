class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stck = new Stack();
        Stack<String> stckCh= new Stack();
       
        for(String ch: tokens){
            if(ch.equals("+") || ch.equals("-") || ch.equals("*")|| ch.equals("/")){
                stckCh.push(ch);
                while(!stckCh.isEmpty()){
                    int b = stck.pop();
                    int a = stck.pop();
                    int res =0;
                    String ops= stckCh.pop();
                    if(ops.equals("+")){
                        res=a+b;
                    }else if(ops.equals("-")){
                        res=a-b;
                    }else if(ops.equals("*")){
                        res=a*b;
                    }
                    else if(ops.equals("/")){
                        res=a/b;
                    }
                    stck.push(res);
                    
                }
            }else{
                stck.push(Integer.parseInt(ch));
            }
        }

     

        return stck.pop();
    }
}

/**Antoher Apporach */
// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> stck = new Stack<>();
       
//         for (String ch : tokens) {
//             if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
//                 // Pop the top two numbers from the stack
//                 int b = stck.pop();
//                 int a = stck.pop();
//                 int res = 0;

//                 // Perform the operation
//                 switch (ch) {
//                     case "+":
//                         res = a + b;
//                         break;
//                     case "-":
//                         res = a - b;
//                         break;
//                     case "*":
//                         res = a * b;
//                         break;
//                     case "/":
//                         res = a / b;
//                         break;
//                 }
//                 // Push the result back onto the stack
//                 stck.push(res);
//             } else {
//                 // Push operands directly onto the stack
//                 stck.push(Integer.parseInt(ch));
//             }
//         }

//         // The final result will be the only element left in the stack
//         return stck.pop();
//     }
// }