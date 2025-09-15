import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int Start = intervals[0][0], End = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0], currEnd = intervals[i][1];

            if (currStart <= End) {
                // overlap → extend current
                End = Math.max(End, currEnd);
            } else {
                // no overlap → commit current and start new
                merged.add(new int[]{Start, End});
                Start = currStart;
                End = currEnd;
            }
        }
        // push the final interval
        merged.add(new int[]{Start, End});

        return merged.toArray(new int[merged.size()][]);
    }
}
