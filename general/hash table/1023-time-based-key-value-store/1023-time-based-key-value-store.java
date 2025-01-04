class Pair{
    int timeStamp;
    String val;
    Pair(int t, String val){
        this.timeStamp=t;
        this.val=val;
    }
}


class TimeMap {
    HashMap<String, ArrayList<Pair>> hMap;
    public TimeMap() {
        hMap= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hMap.containsKey(key)){
            hMap.get(key).add(new Pair(timestamp,value));
        }else{
            ArrayList<Pair> arr= new ArrayList<>();
            arr.add(new Pair(timestamp,value));
            hMap.put(key,arr);
        }
    }
    
    public String get(String key, int timestamp) {
        String cand="";

        if(hMap.containsKey(key)){
            ArrayList<Pair> arr = hMap.get(key);
            int low =0; int high= arr.size()-1;

            while(low<=high){
                int mid = low + (high-low)/2;

                int timeVal= arr.get(mid).timeStamp;

                if(timeVal == timestamp){
                    return arr.get(mid).val;
                }else if(timeVal < timestamp){
                    cand= arr.get(mid).val;
                    low = mid+1;
                }else{
                    high = mid-1;
                }

            }
        }

        return cand;
      
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */