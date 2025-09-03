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
        if (i == null) return false;

        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);

        // move lastVal into position i
        nums.set(i, lastVal);
        idx.put(lastVal, i);

        // remove last
        nums.remove(lastIdx);
        idx.remove(val);
        return true;
    }
    
    public int getRandom() {
        int r = rand.nextInt(nums.size()); // uniform in [0, size)
        return nums.get(r);
    }
}
