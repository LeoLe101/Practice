package src.Leetcode.Companies.Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC56MergeIntervals {

    /**
     * Space (N) - Required for sort algo
     * 
     * Time (N) - Traverse through the interval once to merge all the intervals
     */
    public int[][] merge(int[][] interval) {
        List<int[]> result = new LinkedList<>();
        if (interval.length < 1)
            return result.toArray(new int[result.size()][]);

        // Sort all interval from the least time start till longest
        Arrays.sort(interval, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;
        int end = 1;
        int[] currInterval = interval[start];

        for (int[] nextInterval : interval) {

            // Update the end time of current interval to merge the overlapping interval
            if (currInterval[end] >= nextInterval[start]) {
                currInterval[end] = Math.max(currInterval[end], nextInterval[end]);
            }
            // Both intervals are not overlap, move curr interval to the next interval
            else {
                result.add(currInterval);
                currInterval = nextInterval;
            }
        }
        result.add(currInterval);
        return result.toArray(new int[result.size()][]);
    }
}
