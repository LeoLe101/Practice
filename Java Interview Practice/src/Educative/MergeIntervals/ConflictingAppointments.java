package src.Educative.MergeIntervals;

import java.util.Arrays;
import src.Educative.Interval;

public class ConflictingAppointments {

    // Space (N) - Time (N Log N) Due to the sorting for the array
    public boolean canAttendAllAppointments(Interval[] intervals) {
        // Sort arr
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start) );

        Interval prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            // Check if the prev and the curr is overlapped
            if (prev.end > curr.start) {
                return false;
            }
            prev = curr;
        }

        return true;
    }
    
}
