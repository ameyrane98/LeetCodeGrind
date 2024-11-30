class Solution {
   
    Stack<String> stck= new Stack();
    Stack<String> stck1= new Stack();
    public String simplifyPath(String path) {
        int path_size= path.length();
        String[] directories = path.split("/");

        for(int i =0; i<directories.length; i++){
            if(directories[i].equals("")){
                continue;
            }
            else if(directories[i].equals("..")){
                if(!stck.isEmpty()){
                    stck.pop();
                }
             
                continue;
            }else if(directories[i].equals(".")){
                continue;
            }
            else{
                 stck.push(directories[i]);
                 
            }

           
        }
        StringBuilder str= new StringBuilder();
        while(!stck.isEmpty()){
            stck1.push(stck.pop());
            
        }

        while(!stck1.isEmpty()){
            String s =stck1.pop();
          
            str.append("/").append(s);
        }

        System.out.println(Arrays.toString(directories));
        System.out.println(Arrays.toString(stck1.toArray()));
        return str.toString().equals("")? "/" : str.toString();
    }
};