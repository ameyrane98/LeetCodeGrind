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