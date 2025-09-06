class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return true;

        int[] delta = new int[1001]; // problem constraint: 0..1000
        for (int[] t : trips) {
            delta[t[1]] += t[0];
            delta[t[2]] -= t[0]; // drop at end
        }
        System.out.println(Arrays.toString(delta));
        int onboard = 0;
        for (int x = 0; x <= 1000; x++) {
            onboard += delta[x];
            if (onboard > capacity) return false;
        }
        return true;
    }
}
