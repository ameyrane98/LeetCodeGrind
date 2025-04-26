import java.util.*;

class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Integer> entry = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int[] ans = new int[n];
        
        int time = 0;
        int lastState = 1; // Assume last used for exit initially
        int i = 0; // Pointer to people

        while (i < n || !entry.isEmpty() || !exit.isEmpty()) {
            // 1. Add all people who arrive at current time
            while (i < n && arrival[i] <= time) {
                if (state[i] == 0) {
                    entry.add(i);
                } else {
                    exit.add(i);
                }
                i++;
            }
            
            // 2. Decide who can cross
            if (!exit.isEmpty() && (lastState == 1 || entry.isEmpty())) {
                int idx = exit.poll();
                ans[idx] = time;
                lastState = 1;
            } else if (!entry.isEmpty()) {
                int idx = entry.poll();
                ans[idx] = time;
                lastState = 0;
            } else {
                // No one is crossing now
                lastState = 1; // Reset to exit priority if idle
            }
            
            time++;
        }
        
        return ans;
    }
}
