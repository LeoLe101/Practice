package src.Edu.MergeIntervals;

import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {
    // Space (N) - Time (N)
    // This solution make the whole process of merging and inserting the new
    // interval into 1 loop
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length <= 0)
            return new int[][] { newInterval };
        if (newInterval.length <= 0)
            return intervals;

        boolean isDoneMerging = false;
        List<int[]> result = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            // Case curr interval is not overlapped and on left side of new interval
            if (isDoneMerging || currInterval[1] < newInterval[0]) {
                result.add(currInterval);
            }
            // Case curr interval is not overlapped and on right side of new interval
            else if (newInterval[1] < currInterval[0]) {
                result.add(newInterval);
                result.add(currInterval);
                isDoneMerging = true;
            }
            // Case curr and new interval overlapped
            else {
                // merge them
                newInterval[0] = Math.min(newInterval[0], currInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currInterval[1]);
            }
        }

        // Add newInterval and other merged interval if not finished merging and this is
        // the last interval in the arr
        if (!isDoneMerging)
            result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    // Space (N) - Time (N)
    // Space is N because we have to return a new list to hold the merged intervals
    public int[][] insertV2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;

        // Put all left intervals that is not overlapped with the new interval into arr
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all the overlapped intervals with new interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Put the rest of the intervals into the arr since after all merged interval
        // added
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

}
