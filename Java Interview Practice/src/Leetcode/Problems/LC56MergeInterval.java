package src.Leetcode.Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC56MergeInterval {

    // Space (N) - Time (N Log N)
    // Space N is because of the sorting list algo
    // Time N Log N is also because the same reason
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList<>();

        // Sort the list by comparing the start of each intervals
        Arrays.sort(intervals, (intervalA, intervalB) -> Integer.compare(intervalA[0], intervalB[0]));
        int[] curr = intervals[0];
        // Loop through the arr of interval
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Check if the end of the next interval within the curr interval (these 2
            // interval overlapped)
            if (next[0] <= curr[1]) {
                // Fix the end of curr interval if the next interval end is more than curr
                curr[1] = Math.max(curr[1], next[1]);
            }
            // These 2 intervals are not overlapped
            else {
                result.add(curr);
                curr = next;
            }
        }
        result.add(curr);
        return result.toArray(new int[result.size()][]);
    }
}
