import java.util.*;

class RandomizedSet {
    private final ArrayList<Integer> nums;
    private final HashMap<Integer, Integer> idx;
    private final Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        idx = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        Integer i = idx.get(val);
        if(i==null) return false; // number not present
        int lastIdx= nums.size()-1;
        int lastVal= nums.get(lastIdx);

        nums.set(i,lastVal);
        idx.put(lastVal,i);

        nums.remove(lastIdx);
        idx.remove(val);
        return true;
    }
    
    public int getRandom() {
        int r = (int) (Math.random() * nums.size()); // uniform in [0, size)
        return nums.get(r);
    }
}
