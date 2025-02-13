class Solution {
    HashMap<String,String> hMap= new HashMap();
    List<String> res= new ArrayList();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res; // Edge case: empty input

        hMap.put("2","abc");
        hMap.put("3","def");
        hMap.put("4","ghi");
        hMap.put("5","jkl");
        hMap.put("6","mno");
        hMap.put("7","pqrs");
        hMap.put("8","tuv");
        hMap.put("9","wxyz");

        StringBuilder str= new StringBuilder();
        solve(digits,str,0);
        return res;
    }

    public void solve(String digits,StringBuilder temp,int index){
        if(index>=digits.length()){
            res.add(temp.toString());
            return;
        }

        String data=hMap.get(Character.toString(digits.charAt(index)));

        for(int end=0; end < data.length(); end++){
 
            temp.append(data.charAt(end));// 2 3-> index here index+1 to go to 3;
            solve(digits,temp,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}