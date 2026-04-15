function isValid(s: string): boolean {
    let stack : string[] = [];

    for(let i=0; i<s.length; i++){
        if(s.charAt(i)==='(' ||  s.charAt(i)==='{' || s.charAt(i)==='[' ){
            stack.push(s.charAt(i));
           
        }else if(s.charAt(i)=== ')' && '(' === stack[stack.length - 1]){
            stack.pop();  
        }
        else if(s.charAt(i)=== ']' && '[' === stack[stack.length - 1]){
            stack.pop();  
        }
        else if(s.charAt(i)=== '}' && '{' === stack[stack.length - 1]){
            stack.pop();  
        }else{
            stack.push(s.charAt(i));
        }

    }
    
    return stack.length === 0;
};  