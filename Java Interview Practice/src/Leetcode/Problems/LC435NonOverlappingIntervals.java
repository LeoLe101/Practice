package src.Leetcode.Problems;

import java.util.Arrays;

public class LC435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 1)
            return 0;

        // Sort the arr
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = intervals[0];
        int result = 0;

        // Check if there is overlaped
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            // overlapped, set prev to the interval with the min end
            if (prev[1] > curr[0]) {
                prev = (prev[1] <= curr[1]) ? prev : curr;
                result++;
            } else {
                prev = curr;
            }
        }
        return result;
    }

}
